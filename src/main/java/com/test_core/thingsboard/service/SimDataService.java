package com.test_core.thingsboard.service;

import com.test_core.thingsboard.common.SimData;

public interface SimDataService {

    SimData save(SimData simData, String deviceID, String meterId) throws Exception;
}
