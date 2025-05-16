package com.test_core.thingsboard.service;

import static com.test_core.thingsboard.dao.DataUtils.getMetaDataName;

import static com.test_core.thingsboard.dao.DataUtils.getOsDataId;

import static org.thingsboard.server.dao.util.TimeUtils.getProductionAndValidFromDate;

import static com.test_core.thingsboard.entity.ModelConstants.BM2;
import static com.test_core.thingsboard.entity.ModelConstants.BM3;
import static com.test_core.thingsboard.entity.ModelConstants.BM4;
import static com.test_core.thingsboard.entity.ModelConstants.BMA_1_0_VERSION;
import static com.test_core.thingsboard.entity.ModelConstants.BMA_SET_VERSION;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test_core.thingsboard.common.ThingsboardErrorCode;
import com.test_core.thingsboard.customException.ThingsboardException;
import com.test_core.thingsboard.dao.JpaAssetInstallationDao;
import com.test_core.thingsboard.dao.MeterDao;
import com.test_core.thingsboard.entity.Meter;

@Service
public class DefaultTbMeterServiceImpl implements TbMeterService {
	
	@Autowired
	MeterService meterService;
	
	@Autowired
	MeterDao meterDao;
	
	@Autowired
	JpaAssetInstallationDao jpaAssetInstallationDao;
	
    @Override
    public String saveapplatestversion(String deviceID, String appVersion, String appUpdatedDate) throws
            ThingsboardException {
        String version = null;
        Meter meter = null;
        try {
            meter = meterService.fetchByDeviceId(deviceID);
            if (meter != null) {
                meter.setSwVersion(appVersion);
                if (appUpdatedDate != null) {
                    LocalDateTime localDateTime;
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    try {
                        localDateTime = LocalDateTime.parse(appUpdatedDate, formatter);
                    } catch (Exception e) {
                        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                        localDateTime = LocalDateTime.parse(appUpdatedDate, formatter);
                    }
                    Instant instant = localDateTime.atZone(ZoneId.of("UTC")).toInstant();
                    meter.setUpdatedTime(new Timestamp(instant.toEpochMilli()));
                }
                meter = meterDao.saveMeter(meter);
                version = meter.getSwVersion();
            }
        } catch (Exception e) {
            throw new ThingsboardException(e.getMessage(), ThingsboardErrorCode.GENERAL);
        }
        return version;
    }
    @Override
    public Map<String, Object> getmeterid(String deviceID, String motherBoardSerialNo, String ethMac) throws
            ThingsboardException {
        Map<String, Object> response = new HashMap<>();
        Meter meter = null;
        meter = meterService.fetchByDeviceId(deviceID);
        if (meter != null) {
            meter.setMotherboardSerialNo(motherBoardSerialNo);
            meter.setEthernetMac(ethMac);
            try {
                meterDao.saveMeter(meter);
            } catch (Exception e) {
                throw new ThingsboardException(e.getMessage(), ThingsboardErrorCode.GENERAL);
            }
            if (meter.getMeterId() != null) {
                response.put("meterId", meter.getMeterId().toString());
                if (meter.getStatusId() != null && meter.getStatusId().equals(15L)) {
                    Long hhid = jpaAssetInstallationDao.getHouseHoldIdByMeterId(meter.getMeterId());
                    response.put("householdId", hhid != null ? hhid.toString() : "");
                } else
                    response.put("householdId", "");
            } else {
                response.put("meterId", "");
                response.put("householdId", "");
            }
        }
        return response;
    }
    private void setMeterStatusProductionDateValidFromAndCreatedTime(Meter meter) {
        meter.setStatusId(16L);
        meter.setCreatedTime(new Timestamp(System.currentTimeMillis()));
        meter.setProductionDate(getProductionAndValidFromDate());
        meter.setValidFrom(meter.getProductionDate());
    }
    private String getMeterVersion(String meterId, String hwVersion) {
        String osVersion = null;
        if (hwVersion != null) {
            if (hwVersion.startsWith("2"))
                osVersion = BM2;
            if (hwVersion.startsWith("3"))
                osVersion = BM3;
            if (hwVersion.startsWith("4"))
                osVersion = BM4;
        } else {
            if (meterId.startsWith("52") || meterId.startsWith("51"))
                osVersion = BMA_SET_VERSION;
            if (meterId.startsWith("54"))
                osVersion = BMA_1_0_VERSION;
            if (meterId.startsWith("1"))
                osVersion = BM2;
            if (meterId.startsWith("3"))
                osVersion = BM3;
            if (meterId.startsWith("4"))
                osVersion = BM4;
        }
        return osVersion;
    }
    @Override
    public String updateprintedmeterid(String deviceID, String meterId) throws ThingsboardException {
        String meterIdUpdated = null;
        Meter meter = null;

        meter = meterService.fetchByDeviceId(deviceID);
        if (meter != null) {
            if (meter.getMeterId() == null || meter.getMeterId().equals(meter.getDeviceId())) {
                meter.setMeterId(Long.valueOf(meterId));
                setMeterStatusProductionDateValidFromAndCreatedTime(meter);
                meter.setOsTypeId(getOsDataId(getMetaDataName(38L), getMeterVersion(meterId, null)));
                try {
                    meter = meterDao.saveOrUpdateMeter(meter, false, meter.getUpdatedBy());
                } catch (Exception e) {
                    throw new ThingsboardException(e.getMessage(), ThingsboardErrorCode.GENERAL);
                }
            }
            meterIdUpdated = meter.getMeterId().toString();
        }
        return meterIdUpdated;
    }
}
