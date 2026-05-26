package com.projectmannage.ProjetMannage.infrastructure.exeption;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RestError {
    private String errorCode;
    private String errorMessage;
    private int status;
    private String path;
}
