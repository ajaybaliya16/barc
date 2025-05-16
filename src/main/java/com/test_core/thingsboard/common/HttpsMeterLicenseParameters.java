package com.test_core.thingsboard.common;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HttpsMeterLicenseParameters {
    @JsonProperty("authorization_code")
    private String authorizationCode;
    @JsonProperty("lock_password")
    private Boolean lockPassword;
    private Metadata metadata;
}
