package com.test_core.thingsboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test_core.thingsboard.customException.ThingsboardException;
import com.test_core.thingsboard.dao.MeterDao;
import com.test_core.thingsboard.entity.Meter;
import com.test_core.thingsboard.entity.MeterEntity;

@Service
public class MeterServiceimpl implements MeterService {
	
    @Autowired
    private MeterDao meterDao;
    
    public Meter fetchByDeviceId(String deviceId) throws Exception {
        return meterDao.findByDeviceId(deviceId);
    }

}
