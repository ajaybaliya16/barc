package com.test_core.thingsboard.entity;


import static com.test_core.thingsboard.dao.AppConstant.*;
import static com.test_core.thingsboard.dao.DataUtils.*;
import static com.test_core.thingsboard.dao.TimeUtils.*;
import static com.test_core.thingsboard.entity.ModelConstants.ASSET_SERIAL_NUMBER;
import static com.test_core.thingsboard.entity.ModelConstants.AUDIO_SOURCE_STATUS;
import static com.test_core.thingsboard.entity.ModelConstants.AUDIO_SOURCE_TS;
import static com.test_core.thingsboard.entity.ModelConstants.AUTH_CODE;
import static com.test_core.thingsboard.entity.ModelConstants.BARC_SCHEMA;
import static com.test_core.thingsboard.entity.ModelConstants.BIOS_VERSION;
import static com.test_core.thingsboard.entity.ModelConstants.BLE_ADDRESS;
import static com.test_core.thingsboard.entity.ModelConstants.CREATED_BY;
import static com.test_core.thingsboard.entity.ModelConstants.CREATED_TIME_PROPERTY;
import static com.test_core.thingsboard.entity.ModelConstants.DEVICE_ID_PROPERTY;
import static com.test_core.thingsboard.entity.ModelConstants.DEVICE_SERIAL_NUMBER;
import static com.test_core.thingsboard.entity.ModelConstants.ETHERNET_MAC;
import static com.test_core.thingsboard.entity.ModelConstants.ID_PROPERTY;
import static com.test_core.thingsboard.entity.ModelConstants.IMEI_BASEBOARD_SERIAL_NO;
import static com.test_core.thingsboard.entity.ModelConstants.IMEI_NUMBER_1;
import static com.test_core.thingsboard.entity.ModelConstants.IMEI_NUMBER_2;
import static com.test_core.thingsboard.entity.ModelConstants.K_LICENCE_KEY;
import static com.test_core.thingsboard.entity.ModelConstants.K_LICENCE_NO;
import static com.test_core.thingsboard.entity.ModelConstants.LAST_CONNECTED_DATE;
import static com.test_core.thingsboard.entity.ModelConstants.LAST_EVENT_ID;
import static com.test_core.thingsboard.entity.ModelConstants.LATITUDE;
import static com.test_core.thingsboard.entity.ModelConstants.LONGITUDE;
import static com.test_core.thingsboard.entity.ModelConstants.MB_SERIAL;
import static com.test_core.thingsboard.entity.ModelConstants.MB_VERSION;
import static com.test_core.thingsboard.entity.ModelConstants.METER_ID;
import static com.test_core.thingsboard.entity.ModelConstants.METER_TABLE_NAME;
import static com.test_core.thingsboard.entity.ModelConstants.MOTHERBOARD_SERIAL_NO;
import static com.test_core.thingsboard.entity.ModelConstants.MOTHERBOARD_VERSION;
import static com.test_core.thingsboard.entity.ModelConstants.NETWORK_OPERATOR;
import static com.test_core.thingsboard.entity.ModelConstants.NETWORK_OPERATOR_NAME;
import static com.test_core.thingsboard.entity.ModelConstants.OS_TYPE_ID;
import static com.test_core.thingsboard.entity.ModelConstants.OTA_COMMIT_HASH;
import static com.test_core.thingsboard.entity.ModelConstants.POWER_PCB_SERIAL_NO;
import static com.test_core.thingsboard.entity.ModelConstants.PRODUCTION_DATE;
import static com.test_core.thingsboard.entity.ModelConstants.REMARK;
import static com.test_core.thingsboard.entity.ModelConstants.SDCARD_PARTNO;
import static com.test_core.thingsboard.entity.ModelConstants.SDCARD_SERIAL;
import static com.test_core.thingsboard.entity.ModelConstants.SIM1_IMSI_ID;
import static com.test_core.thingsboard.entity.ModelConstants.SIM2_IMSI_ID;
import static com.test_core.thingsboard.entity.ModelConstants.SIM_OPERATOR;
import static com.test_core.thingsboard.entity.ModelConstants.SOFTWARE_VERSION;
import static com.test_core.thingsboard.entity.ModelConstants.STATUS_ID;
import static com.test_core.thingsboard.entity.ModelConstants.UPDATED_BY_PROPERTY;
import static com.test_core.thingsboard.entity.ModelConstants.UPDATED_TIME_PROPERTY;
import static com.test_core.thingsboard.entity.ModelConstants.VALID_FROM_TIME_PROPERTY;
import static com.test_core.thingsboard.entity.ModelConstants.VALID_TO_TIME_PROPERTY;
import static com.test_core.thingsboard.entity.ModelConstants.WIFI_MAC;

import java.sql.Timestamp;
import java.util.List;

import com.test_core.thingsboard.dao.AppConstant;
import com.test_core.thingsboard.dao.TimeUtils;
import com.test_core.thingsboard.dao.ToData;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(schema = BARC_SCHEMA, name = METER_TABLE_NAME)
public class MeterEntity implements ToData<Meter> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ID_PROPERTY)
    private Long id;
    @Column(name = METER_ID)
    private Long meterId;

    @Column(name = OS_TYPE_ID)
    private Long osTypeId;

    @Column(name = SOFTWARE_VERSION)
    private String swVersion;

    @Column(name = ETHERNET_MAC)
    private String ethernetMac;

    @Column(name = BLE_ADDRESS)
    private String bleAddress;

    @Column(name = WIFI_MAC)
    private String wifiMac;

    @Column(name = VALID_FROM_TIME_PROPERTY)
    private Timestamp validFrom;

    @Column(name = VALID_TO_TIME_PROPERTY)
    private Timestamp validTo;

    @Column(name = MOTHERBOARD_SERIAL_NO)
    private String motherboardSerialNo;

    @Column(name = IMEI_BASEBOARD_SERIAL_NO)
    private String imeiBaseboardSerialNo;

    @Column(name = POWER_PCB_SERIAL_NO)
    private String powerPcbSerialNo;

    @Column(name = PRODUCTION_DATE)
    private Timestamp productionDate;

    @Column(name = LAST_CONNECTED_DATE)
    private Timestamp lastConnectedDate;

    @Column(name = K_LICENCE_KEY)
    private String kLicenceKey;

    @Column(name = K_LICENCE_NO)
    private String kLicenceNo;

    @Column(name = REMARK)
    private String remark;

    @Column(name = AUTH_CODE)
    private String authCode;

    @Column(name = DEVICE_ID_PROPERTY)
    private String deviceId;

    @Column(name = CREATED_BY)
    private String createdBy;

    @Column(name = UPDATED_BY_PROPERTY)
    private String updatedBy;

    @Column(name = OTA_COMMIT_HASH)
    private String otaCommitHash;

    @Column(name = STATUS_ID)
    private Long statusId;
    @Column(name = UPDATED_TIME_PROPERTY)
    private Timestamp updatedTime;
    @Column(name = BIOS_VERSION)
    private String biosVersion;
    @Column(name = IMEI_NUMBER_1)
    private String imeiNumber1;
    @Column(name = IMEI_NUMBER_2)
    private String imeiNumber2;
    @Column(name = NETWORK_OPERATOR)
    private String networkOperator;
    @Column(name = ASSET_SERIAL_NUMBER)
    private String assetSerialNumber;
    @Column(name = LATITUDE)
    private String latitude;
    @Column(name = LONGITUDE)
    private String longitude;
    @Column(name = SIM1_IMSI_ID)
    private Long sim1ImsiId;
    @Column(name = SIM2_IMSI_ID)
    private Long sim2ImsiId;
    @Column(name = NETWORK_OPERATOR_NAME)
    private String networkOperatorName;
    @Column(name = SIM_OPERATOR)
    private String simOperator;
    @Column(name = SDCARD_PARTNO)
    private String sdcardPartno;
    @Column(name = SDCARD_SERIAL)
    private String sdcardSerial;
    @Column(name = MOTHERBOARD_VERSION)
    private String motherboardVersion;
    @Column(name = DEVICE_SERIAL_NUMBER)
    private String deviceSerialNumber;
    @Column(name = MB_SERIAL)
    private String mbSerial;
    @Column(name = MB_VERSION)
    private String mbVersion;
    @Column(name = LAST_EVENT_ID)
    private Long lastEventId;
    @Column(name = AUDIO_SOURCE_TS)
    private Timestamp audioSourceTs;
    @Column(name = AUDIO_SOURCE_STATUS)
    private String audioSourceStatus;
    @Column(name = CREATED_TIME_PROPERTY)
    private Timestamp createdTime;
    
    @Transient
    private SimDataEntity sim1DataEntity;

    @Transient
    private SimDataEntity sim2DataEntity;

    @Transient
    private Long teststatusId;

    public MeterEntity(MeterEntity meterEntity, SimDataEntity sim1DataEntity, SimDataEntity sim2DataEntity, Long teststatusId) {
        this.id = meterEntity.getId();
        this.meterId = meterEntity.getMeterId();
        this.osTypeId = meterEntity.getOsTypeId();
        this.swVersion = meterEntity.getSwVersion();
        this.ethernetMac = meterEntity.getEthernetMac();
        this.bleAddress = meterEntity.getBleAddress();
        this.wifiMac = meterEntity.getWifiMac();
        this.validFrom = meterEntity.getValidFrom();
        this.validTo = meterEntity.getValidTo();
        this.motherboardSerialNo = meterEntity.getMotherboardSerialNo();
        this.imeiBaseboardSerialNo = meterEntity.getImeiBaseboardSerialNo();
        this.powerPcbSerialNo = meterEntity.getPowerPcbSerialNo();
        this.productionDate = meterEntity.getProductionDate();
        this.lastConnectedDate = meterEntity.getLastConnectedDate();
        this.kLicenceKey = meterEntity.getKLicenceKey();
        this.kLicenceNo = meterEntity.getKLicenceNo();
        this.remark = meterEntity.getRemark();
        this.authCode = meterEntity.getAuthCode();
        this.deviceId = meterEntity.getDeviceId();
        this.createdBy = meterEntity.getCreatedBy();
        this.updatedBy = meterEntity.getUpdatedBy();
        this.otaCommitHash = meterEntity.getOtaCommitHash();
        this.statusId = meterEntity.getStatusId();
        this.updatedTime = meterEntity.getUpdatedTime();
        this.biosVersion = meterEntity.getBiosVersion();
        this.imeiNumber1 = meterEntity.getImeiNumber1();
        this.imeiNumber2 = meterEntity.getImeiNumber2();
        this.networkOperator = meterEntity.getNetworkOperator();
        this.assetSerialNumber = meterEntity.getAssetSerialNumber();
        this.latitude = meterEntity.getLatitude();
        this.longitude = meterEntity.getLongitude();
        this.sim1ImsiId = meterEntity.getSim1ImsiId();
        this.sim2ImsiId = meterEntity.getSim2ImsiId();
        this.networkOperatorName = meterEntity.getNetworkOperatorName();
        this.simOperator = meterEntity.getSimOperator();
        this.sdcardPartno = meterEntity.getSdcardPartno();
        this.sdcardSerial = meterEntity.getSdcardSerial();
        this.motherboardVersion = meterEntity.getMotherboardVersion();
        if (sim1DataEntity != null)
            this.sim1DataEntity = sim1DataEntity;
        if (sim2DataEntity != null)
            this.sim2DataEntity = sim2DataEntity;
        this.teststatusId = teststatusId;
        this.deviceSerialNumber = meterEntity.getDeviceSerialNumber();
        this.mbSerial = meterEntity.getMbSerial();
        this.mbVersion = meterEntity.getMbVersion();
        this.lastEventId = meterEntity.getLastEventId();
        this.audioSourceTs = meterEntity.getAudioSourceTs();
        this.audioSourceStatus = meterEntity.getAudioSourceStatus();
        this.createdTime = meterEntity.getCreatedTime();
    }

    public MeterEntity(Meter meter) {
        if (meter.getId() != null)
            this.id = meter.getId();
        this.meterId = meter.getMeterId();
        this.osTypeId = meter.getOsTypeId();
        this.swVersion = meter.getSwVersion();
        this.ethernetMac = meter.getEthernetMac();
        this.bleAddress = meter.getBleAddress();
        this.wifiMac = meter.getWifiMac();
        if (meter.getValidFrom() != null && !meter.getValidFrom().isEmpty())
            this.validFrom = TimeUtils.convertDateToTimestamp(meter.getValidFrom(), AppConstant.DATE_FORMAT);
        if (meter.getValidTo() != null && !meter.getValidTo().isEmpty())
            this.validTo = TimeUtils.convertDateToTimestamp(meter.getValidTo());
        this.motherboardSerialNo = meter.getMotherboardSerialNo();
        this.imeiBaseboardSerialNo = meter.getImeiBaseboardSerialNo();
        this.powerPcbSerialNo = meter.getPowerPcbSerialNo();
        if (meter.getProductionDate() != null && !meter.getProductionDate().isEmpty())
            this.productionDate = TimeUtils.convertDateToTimestamp(meter.getProductionDate());
        this.lastConnectedDate = meter.getLastConnectedDate();
        this.kLicenceKey = meter.getLicenseKey();
        this.kLicenceNo = meter.getLicenseNo();
        this.remark = meter.getRemark();
        this.authCode = meter.getAuthcode();
        this.deviceId = meter.getDeviceId();
        this.createdBy = meter.getCreatedBy();
        this.updatedBy = meter.getUpdatedBy();
        this.otaCommitHash = meter.getOtaCommitHash();
        this.statusId = meter.getStatusId();
        this.updatedTime = meter.getUpdatedTime();
        this.biosVersion = meter.getBiosVersion();
        this.imeiNumber1 = meter.getImeiNumber1();
        this.imeiNumber2 = meter.getImeiNumber2();
        this.networkOperator = meter.getNetworkOperator();
        this.assetSerialNumber = meter.getAssetSerialNumber();
        this.latitude = meter.getLatitude();
        this.longitude = meter.getLongitude();
        this.sim1ImsiId = meter.getSim1ImsiId();
        this.sim2ImsiId = meter.getSim2ImsiId();
        this.networkOperatorName = meter.getNetworkOperatorName();
        this.simOperator = meter.getSimOperator();
        this.sdcardPartno = meter.getSdCardPartNo();
        this.sdcardSerial = meter.getSdCardSerial();
        this.motherboardVersion = meter.getMotherboardVersion();
        this.teststatusId = meter.getTeststatusId();
        this.deviceSerialNumber = meter.getDeviceSerialNumber();
        this.mbVersion = meter.getMbVersion();
        this.mbSerial = meter.getMbSerial();
        this.lastEventId = meter.getLastEventId();
        this.audioSourceTs = meter.getAudioSourceTs();
        this.audioSourceStatus = meter.getAudioSourceStatus();
        this.createdTime = meter.getCreatedTime();
    }

    @Override
    public Meter toData() {
        Meter meter = new Meter();
        if (this.id != null)
            meter.setId(this.id);
        meter.setMeterId(this.meterId);
        meter.setOsTypeId(this.osTypeId);
        if (this.osTypeId != null) {
            // Fetch OS type and hardware version list using osTypeId
            List<String> osTypeAndHwVersionList = getOSTypeAndHwVersion(this.osTypeId);
            if (osTypeAndHwVersionList != null && !osTypeAndHwVersionList.isEmpty()) {
                meter.setOsType(osTypeAndHwVersionList.get(0));
                meter.setHardwareVersion(osTypeAndHwVersionList.get(1));
            } else {
                // Manually set default values if list is null or empty
                meter.setOsType("3"); // Assuming "3" is the default osType
                meter.setHardwareVersion("default_version"); // Replace with appropriate default
            }
        } else {
            // If osTypeId is null, set default values
            meter.setOsType("3"); // Assuming "3" is the default osType
            meter.setHardwareVersion("default_version"); // Replace with appropriate default
        }
        meter.setSwVersion(this.swVersion);
        meter.setEthernetMac(this.ethernetMac);
        meter.setBleAddress(this.bleAddress);
        meter.setWifiMac(this.wifiMac);
        if (this.validFrom != null)
            meter.setValidFrom(TimeUtils.convertTimestampToDateStr(this.validFrom));
        if (this.validTo != null)
            meter.setValidTo(TimeUtils.convertTimestampToDateStr(this.validTo));
        if (this.validFrom != null && !meter.getValidFrom().isEmpty())
            this.validFrom = TimeUtils.convertDateToTimestamp(meter.getValidFrom());
        if (meter.getValidTo() != null && !meter.getValidTo().isEmpty())
            this.validTo = TimeUtils.convertDateToTimestamp(meter.getValidTo());
        meter.setMotherboardSerialNo(this.motherboardSerialNo);
        meter.setImeiBaseboardSerialNo(this.imeiBaseboardSerialNo);
        meter.setPowerPcbSerialNo(this.powerPcbSerialNo);
        if (this.productionDate != null)
            meter.setProductionDate(TimeUtils.convertTimestampToDateStr(this.productionDate));
        meter.setLastConnectedDate(this.lastConnectedDate);
        meter.setLicenseKey(this.kLicenceKey);
        meter.setLicenseNo(this.kLicenceNo);
        meter.setRemark(this.remark);
        meter.setAuthcode(this.authCode);
        meter.setDeviceId(this.deviceId);
        meter.setCreatedBy(this.createdBy);
        meter.setUpdatedBy(this.updatedBy);
        meter.setOtaCommitHash(this.otaCommitHash);
        meter.setStatusId(this.statusId);
        if (this.statusId != null)
            meter.setStatusName(getMetaDataName(this.statusId));
        meter.setUpdatedTime(this.updatedTime);
        meter.setBiosVersion(this.biosVersion);
        meter.setImeiNumber1(this.imeiNumber1);
        meter.setImeiNumber2(this.imeiNumber2);
        meter.setNetworkOperator(this.networkOperator);
        meter.setAssetSerialNumber(this.assetSerialNumber);
        meter.setLatitude(this.latitude);
        meter.setLongitude(this.longitude);
        meter.setSim1ImsiId(this.sim1ImsiId);
        meter.setSim2ImsiId(this.sim2ImsiId);
        meter.setNetworkOperatorName(this.networkOperatorName);
        meter.setSimOperator(this.simOperator);
        meter.setSdCardPartNo(this.sdcardPartno);
        meter.setSdCardSerial(this.sdcardSerial);
        meter.setMotherboardVersion(this.motherboardVersion);
        if (sim1DataEntity != null) {
            meter.setSim1ServiceProvider(getMetaDataName(sim1DataEntity.getServiceProviderId()));
            meter.setSim1Serial(sim1DataEntity.getSimSerial());
            meter.setSim1Imsi(sim1DataEntity.getImsi());
            meter.setSim1PhoneNo(sim1DataEntity.getPhoneNo());
        }
        if (sim2DataEntity != null) {
            meter.setSim2ServiceProvider(getMetaDataName(sim2DataEntity.getServiceProviderId()));
            meter.setSim2Serial(sim2DataEntity.getSimSerial());
            meter.setSim2Imsi(sim2DataEntity.getImsi());
            meter.setSim2PhoneNo(sim2DataEntity.getPhoneNo());
        }
        if (this.teststatusId != null)
            meter.setTestStatus(getMetaDataName(this.teststatusId));
        meter.setDeviceSerialNumber(this.deviceSerialNumber);
        meter.setMbSerial(this.mbSerial);
        meter.setMbVersion(this.mbVersion);
        meter.setLastEventId(this.lastEventId);
        meter.setAudioSourceTs(this.audioSourceTs);
        meter.setAudioSourceStatus(this.audioSourceStatus);
        meter.setCreatedTime(this.createdTime);
        return meter;
    }
}