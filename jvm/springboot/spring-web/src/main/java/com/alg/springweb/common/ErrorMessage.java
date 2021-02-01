package com.alg.springweb.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class ErrorMessage {
    @NotNull
    private int status;
    @NotNull
    private String message;
}
