package com.test_core.thingsboard.common;


import lombok.Data;

@Data
public class SimData {
    private Long id;
    private String imsi;
    private String simSerial;
    private Long serviceProviderId;
    private String phoneNo;
    private String serviceProvider;
}
