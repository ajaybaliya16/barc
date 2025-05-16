package com.test_core.thingsboard.common;


import lombok.Data;

@Data
public class HttpsMeterLicenseRequest {
    private String type;
    private String pool;
    private HttpsMeterLicenseParameters parameters;
}
