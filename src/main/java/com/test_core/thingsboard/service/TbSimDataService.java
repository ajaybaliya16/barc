package com.test_core.thingsboard.service;


import org.springframework.validation.BindingResult;

import com.test_core.thingsboard.common.SimData;
import com.test_core.thingsboard.common.SimInfo;
import com.test_core.thingsboard.customException.ThingsboardException;


public interface TbSimDataService {
	
    SimData save(SimInfo simInfo, BindingResult bindingResult) throws Exception;

    SimData saveSimData(String deviceID, String meterId, String imsi, String simSerial, String serviceProvider, String phoneNo, Long serviceProviderId) throws Exception;
}
