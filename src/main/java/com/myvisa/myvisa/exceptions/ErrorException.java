package com.myvisa.myvisa.exceptions;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorException {
    private String message;

    public ErrorException(String message) {
        this.message = message;
    }
}
