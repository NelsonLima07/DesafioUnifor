package com.uni4.dto;

import java.io.Serializable;

public record UserKeycloakDTO(
    String username,
    String email,
    String firstName,
    String lastName,
    boolean enabled,
    Credential[] credentials
) implements Serializable {

    public static record Credential(
        String type,
        String value,
        boolean temporary
    ) implements Serializable {
        public Credential(String value) {
            this("password", value, false);
        }
    }
}
