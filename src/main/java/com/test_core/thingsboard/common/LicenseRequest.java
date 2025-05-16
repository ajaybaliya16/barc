package com.test_core.thingsboard.common;


import lombok.Data;

@Data
public class LicenseRequest {
    private String type;
    private String pool;
    private Parameters parameters;
}
