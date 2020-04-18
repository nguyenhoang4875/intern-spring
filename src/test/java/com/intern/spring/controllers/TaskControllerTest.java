package com.intern.spring.controllers;

import com.google.gson.Gson;
import com.intern.spring.models.Task;
import com.intern.spring.services.TaskService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration.class})
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TaskService taskService;

    private Task task1;
    private Task task2;

    @BeforeEach
    public void init() {
        task1 = new Task(1, "login", "teo", LocalDateTime.of(2020, 4, 18, 22, 00, 00), "pass full test", "TODO");
        task2 = new Task(2, "logout", "ti", LocalDateTime.of(2020, 4, 18, 23, 00, 00), "pass full test", "INPROGRESS");
        taskService.save(task1);
        taskService.save(task2);
    }

    @AfterEach
    public void destroy() {
        taskService.deleteById(1);
        taskService.deleteById(2);
    }

    @Test
    public void test_getAllTask() throws Exception {
        mockMvc.perform(get("/api/tasks"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", Matchers.hasSize(2)))
                .andExpect(jsonPath("$[0].id", Matchers.equalTo(task1.getId())))
                .andExpect(jsonPath("$[0].name", Matchers.equalTo("login")))
                .andExpect(jsonPath("$[1].id", Matchers.equalTo(task2.getId())))
                .andExpect(jsonPath("$[1].name", Matchers.equalTo("logout")));
    }

    @Test
    public void test_getTask_Found() throws Exception {
        mockMvc.perform(get("/api/tasks/" + task2.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", Matchers.equalTo(task2.getId())))
                .andExpect(jsonPath("$.name", Matchers.equalTo(task2.getName())));
    }

    @Test
    public void test_getTask_NotFound() throws Exception {
        mockMvc.perform(get("/api/tasks/" + (task1.getId() + task2.getId())))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void test_deleteTask_NotFound() throws Exception {
        mockMvc.perform(delete("/api/tasks/" + (task1.getId() + task2.getId())))
                .andExpect(status().isNotFound());
    }

    @Test
    public void test_deleteTask_Found() throws Exception {
        mockMvc.perform(delete("/api/tasks/" + task1.getId()))
                .andExpect(status().isOk());
        assertFalse(taskService.findById(task1.getId()).isPresent());
    }

    @Test
    public void test_put_Found() throws Exception {
        Gson gson = new Gson();
        String json = gson.toJson(new Task(task2.getId(), "homepage", "ti", LocalDateTime.of(2020, 4, 18, 23, 00, 00), "pass full test", "INPROGRESS"));

        mockMvc.perform(put("/api/tasks")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk());

        Optional<Task> task = taskService.findById(task2.getId());
        assertTrue(task.isPresent());
        assertEquals(task.get().getName(), "homepage");
    }

    @Test
    public void test_post_ok() throws Exception {
        Gson gson = new Gson();
        String json = gson.toJson(new Task(0, "animation", "ti", LocalDateTime.of(2020, 4, 18, 17, 00, 00), "pass full test", "DONE"));

        mockMvc.perform(post("/api/tasks")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk());

        ArrayList<Task> tasks = (ArrayList<Task>) taskService.findAll();
        Task task = tasks.get(tasks.size() - 1);
        assertEquals(task.getName(), "animation");
    }
}
