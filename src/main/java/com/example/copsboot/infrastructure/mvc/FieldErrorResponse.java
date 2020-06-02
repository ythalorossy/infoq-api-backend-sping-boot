package com.example.copsboot.infrastructure.mvc;

import lombok.Value;

@Value
public class FieldErrorResponse {
    String fieldName;
    String errorMessage;
}
