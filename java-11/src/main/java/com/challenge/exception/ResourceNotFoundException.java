package com.challenge.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    private String resourceName;

    public String getMessage() {
        return "Recursos : " + resourceName.toUpperCase() + " solicitados não encontrados.";
    }
}
