package com.test_core.thingsboard.common;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Parameters {
    @JsonProperty("authorization_code")
    private String authorizationCode;
    @JsonProperty("lock_password")
    private Boolean lockPassword;
    @JsonProperty("lock_mac")
    private Boolean lockMac;
    private Metadata metadata;
}
