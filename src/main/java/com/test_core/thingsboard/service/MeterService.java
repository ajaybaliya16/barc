package com.test_core.thingsboard.service;

import org.springframework.stereotype.Service;

import com.test_core.thingsboard.entity.Meter;
@Service
public interface MeterService {
	
    Meter fetchByDeviceId(String deviceId) throws Exception;


}
