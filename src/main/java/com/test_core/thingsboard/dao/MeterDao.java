package com.test_core.thingsboard.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test_core.thingsboard.entity.Meter;
import com.test_core.thingsboard.entity.MeterEntity;
import com.test_core.thingsboard.repo.MeterRepository;
	
@Service
public class MeterDao {
	
	@Autowired
	MeterRepository meterRepository;
	
    public Meter findByDeviceId(String deviceId) {
        return DaoUtil.getData(meterRepository.findByDeviceId(deviceId));
    }
    
    public Meter saveMeter(Meter meter) {
        return DaoUtil.getData(meterRepository.save(new MeterEntity(meter)));
    }

    public String getdevicelicensekey(String deviceId) {
        return meterRepository.findLicensekeyByDeviceId(deviceId);
    }

}
