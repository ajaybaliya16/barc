package com.test_core.thingsboard.service;

import com.test_core.thingsboard.customException.ThingsboardException;
import com.test_core.thingsboard.entity.Meter;

public interface MeterService {
	
	 Meter fetchByDeviceId(String deviceId) throws ThingsboardException;
}
