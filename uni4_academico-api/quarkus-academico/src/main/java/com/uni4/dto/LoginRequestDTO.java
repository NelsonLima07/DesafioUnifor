package com.uni4.dto;

import java.io.Serializable;

public record LoginRequestDTO(
    String username,
    String password
) implements Serializable {}
