package com.test_core.thingsboard.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties({"licenseKey", "licenseNo"})
@NoArgsConstructor
@AllArgsConstructor
public class Meter implements Serializable {
    private Long id;
    private Long meterId;
    private String swVersion;
//    @DateFormat(pattern = "dd-MM-yyyy", message = "Production date must be in the format dd-MM-yyyy")
    private String productionDate;
    private String otaCommitHash;
    private String imeiBaseboardSerialNo;
    private String motherboardSerialNo;
    private String powerPcbSerialNo;
    private String ethernetMac;
    private String bleAddress;
    private String wifiMac;
    private String sdCardPartNo;
    private String sdCardSerial;
    private String licenseKey;
    private String licenseNo;
    private TestReport testReport;
//    @DateFormat(pattern = "dd-MM-yyyy", message = "validFrom must be in the format dd-MM-yyyy")
    private String validFrom;
//    @DateFormat(pattern = "dd-MM-yyyy", message = "validTo must be in the format dd-MM-yyyy")
    private String validTo;
    private String authcode;
    private String deviceId;
    private Timestamp createdTime;
    private String createdBy;
    private String updatedBy;
    private Long statusId;
    private Long osTypeId;
    private Timestamp updatedTime;
    private String remark;
    private Timestamp lastConnectedDate;
    private String biosVersion;
    private String imeiNumber1;
    private String imeiNumber2;
    private String networkOperator;
    private String assetSerialNumber;
    private String latitude;
    private String longitude;
    private Long sim1ImsiId;
    private Long sim2ImsiId;
    private String networkOperatorName;
    private String simOperator;
    private String motherboardVersion;
    private String statusName;
    private String hardwareVersion;
    private String testStatus;
    private String osType;
    private String sim1ServiceProvider;
    private String sim2ServiceProvider;
    private String sim1Imsi;
    private String sim1Serial;
    private String sim1PhoneNo;
    private String sim2Imsi;
    private String sim2Serial;
    private String sim2PhoneNo;
    private Long teststatusId;
    private String deviceSerialNumber;
    private String mbSerial;
    private String mbVersion;
    private Long lastEventId;
    private Timestamp audioSourceTs;
    private String audioSourceStatus;
    private Boolean fieldAlarmRaised;

    public Meter(Long meterId, Timestamp updatedTime, String hardwareVersion, String statusName, String remark, Long statusId, String updatedBy) {
        this.meterId = meterId;
        this.updatedTime = updatedTime;
        this.hardwareVersion = hardwareVersion;
        this.statusName = statusName;
        this.remark = remark;
        this.statusId = statusId;
        this.updatedBy = updatedBy;
    }
}
