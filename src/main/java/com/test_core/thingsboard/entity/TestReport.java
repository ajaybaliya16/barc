package com.test_core.thingsboard.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TestReport {
    private Long id;
    private Long statusId;
    private String testedBy;
    private String sim1Report;
    private String sim2Report;
    private String rtcVolt;
    private String testDate;
    private Long meterId;
    private String hardwareVersion;
    private String meterType;
    private String status;
}

