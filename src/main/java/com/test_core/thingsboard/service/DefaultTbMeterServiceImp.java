package com.test_core.thingsboard.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test_core.thingsboard.common.SimData;
import com.test_core.thingsboard.dao.MeterDao;
import com.test_core.thingsboard.entity.Meter;
import com.test_core.thingsboard.service.TbSimDataService;

import java.sql.Timestamp;
@Service
public class DefaultTbMeterServiceImp implements TbMeterService {
	
	@Autowired
    MeterService meterService;
	
	@Autowired
	MeterDao meterDao;
	
	@Autowired
    TbSimDataService tbSimDataService;
	
//	@Autowired
//	KantarLicensingService licensingService;
	
	 @Override
	    public void signupdevice(String deviceID, Double lat, Double lng, String meterId, String
	            deviceSerialNumber, String assetSerialNumber, String simSerialNumber, String imeiNumber1,
	                             String imeiNumber2, String simOperator, String networkOperator, String networkOperatorName,
	                             String osVersion, String appVersion, String ethMac, String motherBoardSerialNo, String imsi, String simOperatorName) throws
	            Exception {
	        Meter meter = null;
	        try {
	            meter = meterService.fetchByDeviceId(deviceID);
	            if (meter == null)
	                meter = new Meter();
	            SimData simData = tbSimDataService.saveSimData(deviceID, meterId, imsi, simSerialNumber, simOperatorName, null, null);
	            if (simData == null)
	                throw new Exception("Sim data not saved");
	            meter.setSim1ImsiId(simData.getId());
	            meter.setDeviceId(deviceID);
	            meter.setImeiNumber1(imeiNumber1);
	            meter.setImeiNumber2(imeiNumber2);
	            meter.setSimOperator(simOperator);
	            meter.setNetworkOperator(networkOperator);
	            meter.setNetworkOperatorName(networkOperatorName);
	            if (lat != null)
	                meter.setLatitude(lat.toString());
	            if (lng != null)
	                meter.setLongitude(lng.toString());
	            if (meterId != null && !deviceID.equals(meterId))
	                meter.setMeterId(Long.valueOf(meterId));
	            meter.setSwVersion(appVersion);
	            meter.setDeviceSerialNumber(deviceSerialNumber);
	            meter.setAssetSerialNumber(assetSerialNumber);
	            meter.setCreatedTime(new Timestamp(System.currentTimeMillis()));
	            meterDao.saveMeter(meter);
	        } catch (Exception e) {
	            throw new Exception(e.getMessage());//, ThingsboardErrorCode.GENERAL);
	        }
	    }
	 
	 @Override
	    public String getdevicelicensekey(String deviceID) {
	        return meterDao.getdevicelicensekey(deviceID);
	    }

	 @Override
	    public String generatedevicelicensekey(String deviceID) throws Exception {
	        String licenseKey = null;
	        Meter meter = meterService.fetchByDeviceId(deviceID);
	        if (meter != null) {
	            if (meter.getLicenseKey() == null) {
	            	// THIRD PARTY API TO GET LICENSE 
//	                KantarLicense kantarLicense = licensingService.createLicense(38L, deviceID);
//	                if (kantarLicense != null) {
	                    meter.setLicenseNo("1234567");
	                    meter.setLicenseKey("111111");
	                    meterDao.saveMeter(meter);
	                    licenseKey = "11111111";
//	                }
	            } else
	                licenseKey = meter.getLicenseKey();
	        }
	        return licenseKey;
	    }
}
