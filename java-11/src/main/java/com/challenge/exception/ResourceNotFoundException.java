package com.challenge.exception;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResourceNotFoundException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    private String resourceName;
    private String mensagem;

    public ResourceNotFoundException(String resourceName) {
        this.resourceName = resourceName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMessage() {
        return "Recursos solicitados não encontrados.";
    }
}
