package com.intern.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class SpringInternApplicationTests {

    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @Test
    void contextLoads() {
    }

    @Test
    public void test_dataSourceUrl() {
        Assertions.assertEquals(dataSourceUrl, "jdbc:mysql://localhost:3306/interndb_test");
    }

}
