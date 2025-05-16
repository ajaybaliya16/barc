package com.test_core.thingsboard.service;

import java.util.Map;

import com.test_core.thingsboard.customException.ThingsboardException;

public interface TbMeterService {
    String saveapplatestversion(String deviceID, String appVersion, String appUpdatedDate) throws Exception;
    Map<String, Object> getmeterid(String deviceID, String motherBoardSerialNo, String ethMac) throws ThingsboardException;
    String updateprintedmeterid(String deviceID, String meterId) throws ThingsboardException;
}
