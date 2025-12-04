package com.uni4.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public record TokenDTO (

    @JsonProperty("access_token")
    String accessToken,

    @JsonProperty("refresh_token")
    String refreshToken,

    @JsonProperty("expires_in")
    Long expiresIn,

    @JsonProperty("token_type")
    String tokenType

) implements Serializable {}