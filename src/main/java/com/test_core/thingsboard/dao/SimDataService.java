package com.test_core.thingsboard.dao;

import com.test_core.thingsboard.common.SimData;
import com.test_core.thingsboard.customException.ThingsboardException;

public interface SimDataService {
	SimData save(SimData simData, String deviceID, String meterId) throws ThingsboardException;
}
