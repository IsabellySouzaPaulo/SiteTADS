package com.projectmannage.ProjetMannage.infrastructure.exeption;
import lombok.Getter;

@Getter
public class ResquestExeption extends RuntimeException{
    private final String errorCode;

    public ResquestExeption(String message, String errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}