package com.intern.spring.exeptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomErrorResponse {

    private int status;
    private String message;
    private long timeStamp;

}
