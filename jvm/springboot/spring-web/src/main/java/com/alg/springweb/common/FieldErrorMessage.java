package com.alg.springweb.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class FieldErrorMessage {
    @NotNull
    private String field;
    @NotNull
    private String message;
}
