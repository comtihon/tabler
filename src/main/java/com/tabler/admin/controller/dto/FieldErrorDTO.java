package com.tabler.admin.controller.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class FieldErrorDTO {
    private final String field;
    private final String message;
}
