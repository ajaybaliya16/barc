package com.test_core.thingsboard.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test_core.thingsboard.common.SimData;
import com.test_core.thingsboard.dao.DaoUtil;
import com.test_core.thingsboard.dao.SimDataDao;
import com.test_core.thingsboard.entity.MeterEntity;
import com.test_core.thingsboard.repo.MeterRepository;
import com.test_core.thingsboard.repo.SimDataRepository;

import lombok.extern.slf4j.Slf4j;

@Service("SimDataDaoService")
@Slf4j
public class SimDataServiceImpl implements SimDataService {
    @Autowired
    private SimDataDao simDataDao;
    @Autowired
    private MeterRepository meterRepository;
    @Autowired
    private SimDataRepository simDataRepository;

    @Override
    public SimData save(SimData simData, String deviceID, String meterId) throws Exception {
        SimData existingSimData = null;
        List<String> matchedParams = null;
        if (simData.getImsi() != null) {
            existingSimData = DaoUtil.getData(simDataRepository.findByImsi(simData.getImsi()));
            if (existingSimData != null)
                matchedParams = validateSimData(simData, existingSimData, deviceID, meterId);
        }
        if (matchedParams == null) {
            existingSimData = DaoUtil.getData(simDataRepository.findBySimSerial(simData.getSimSerial()));
            if (existingSimData != null)
                matchedParams = validateSimData(simData, existingSimData, deviceID, meterId);
            if (matchedParams == null) {
                if (simData.getPhoneNo() != null) {
                    existingSimData = DaoUtil.getData(simDataRepository.findByPhoneNo(simData.getPhoneNo()));
                    if (existingSimData != null)
                        matchedParams = validateSimData(simData, existingSimData, deviceID, meterId);
                }
            }
        }
        if (matchedParams != null) {
            if (deviceID != null) {
                simData.setId(existingSimData.getId());
                return simDataDao.save(simData);
            } else {
                if (matchedParams.size() == 4)
                    return existingSimData;
                else
                    throw new Exception("SIM data already exists with matched parameters: " + matchedParams);//, ThingsboardErrorCode.GENERAL);
            }
        } else
            return simDataDao.save(simData);
    }

    private List<String> validateSimData(SimData simData, SimData existingSimData, String deviceID, String meterId) throws Exception {
        List<String> matchedParams = new ArrayList<>();
        if (simData.getSimSerial() != null && existingSimData.getSimSerial() != null && simData.getSimSerial().equals(existingSimData.getSimSerial()))
            matchedParams.add("SIMSERIAL");
        if (simData.getSimSerial() == null && existingSimData.getSimSerial() == null)
            matchedParams.add("SIMSERIAL");
        if (simData.getPhoneNo() != null && existingSimData.getPhoneNo() != null && simData.getPhoneNo().equals(existingSimData.getPhoneNo()))
            matchedParams.add("PHONENO");
        if (simData.getPhoneNo() == null && existingSimData.getPhoneNo() == null)
            matchedParams.add("PHONENO");
        if (simData.getServiceProviderId() != null && existingSimData.getServiceProviderId() != null && simData.getServiceProviderId().equals(existingSimData.getServiceProviderId()))
            matchedParams.add("SERVICEPROVIDERID");
        if (simData.getServiceProviderId() == null && existingSimData.getServiceProviderId() == null)
            matchedParams.add("SERVICEPROVIDERID");
        if (simData.getImsi() != null && existingSimData.getImsi() != null && simData.getImsi().equals(existingSimData.getImsi()))
            matchedParams.add("IMSI");
        if (simData.getImsi() == null && existingSimData.getImsi() == null)
            matchedParams.add("IMSI");
        if (!matchedParams.isEmpty()) {
            MeterEntity meterEntity = meterRepository.findByImsiId(existingSimData.getId());
            if (meterEntity != null) {
                if (meterEntity.getDeviceId() != null) {
                    if (!deviceID.equals(meterEntity.getDeviceId()))
                        throw new Exception("SIM data assigned to a " + (meterEntity.getMeterId() != null ? " meter " + meterEntity.getMeterId() : " device id " + meterEntity.getDeviceId()));//, ThingsboardErrorCode.GENERAL);
                } else {
                    if (matchedParams.size() < 4)
                        throw new Exception("SIM data assigned to a meter " + meterEntity.getMeterId());//, ThingsboardErrorCode.GENERAL);
                }
            }
        }
        return matchedParams;
    }

}