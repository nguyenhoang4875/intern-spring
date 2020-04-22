package com.intern.spring.exeptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CustomNotFoundException extends RuntimeException {
    public CustomNotFoundException(String message) {
        super(message);
    }
}
