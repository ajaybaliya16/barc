package com.test_core.thingsboard.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import ch.qos.logback.core.joran.spi.NoAutoStart;



@Service
public interface TbMeterService {
//    Meter updateMeterStatus(Long meterId, Long statusId) throws Exception;
//
//    PageData<Meter> getMeter(MeterFilter meterFilter, PageLink pageLink, String userName) throws Exception;
//
//    PageData<Meter> getMeterHistory(MeterFilter meterFilter, PageLink pageLink, String userName) throws Exception;
//
//    PageData<MeterConflictInfo> findMeterConflictedInfo(ConflictHistoryFilter filter, PageLink pageLink, String userName);
//
//    ResponseEntity<?> uploadBulkMeters(MultipartFile file, User user);
//
//    Meter saveMeterData(MeterData meterData, String userName, boolean isUpdate) throws Exception;
//
//    Meter saveMeter(Meter meter, String userName, boolean isUpdate) throws Exception;

//    void updateMeterData(Meter oldMeter, Meter newMeter, String userName);
//
//    Map<String, Map<String, Double>> getMeterSummary(MeterFilter meterFilter);
//
//    int updateStatusAndRemark(Long id, ConflictedComponentUpdateRequest request);
//
//    List<Long> getMetersByRange(long start, long end);

    void signupdevice(String deviceID, Double lat, Double lng, String meterId, String deviceSerialNumber, String assetSerialNumber, String simSerialNumber,
                      String imeiNumber1, String imeiNumber2, String simOperator, String networkOperator, String networkOperatorName,
                      String osVersion, String appVersion, String ethMac, String motherBoardSerialNo, String imsi, String simOperatorName) throws Exception;

    String getdevicelicensekey(String deviceID);

//    Map<String, Object> getmeterid(String deviceID, String motherBoardSerialNo, String ethMac) throws Exception;
//
//    String saveapplatestversion(String deviceID, String appVersion, String appUpdatedDate) throws Exception;
//
//    String updateprintedmeterid(String deviceID, String meterId) throws Exception;
//
    String generatedevicelicensekey(String deviceID) throws Exception;
//
//    Map<String, Object> getallmembersfordevicebystatus(String status, String meterId);
//
//    Map<String, Long> getLatestEventId(Long meterId);

//    Meter verifyMeterInfo(MeterData meterData) throws Exception;
}
