package com.intern.spring.exeptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CustomErrorResponse {

    private int status;
    private String message;
    private LocalDateTime dateTime;

}
