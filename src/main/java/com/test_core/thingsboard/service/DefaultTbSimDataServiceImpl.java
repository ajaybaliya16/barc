package com.test_core.thingsboard.service;


import static com.test_core.thingsboard.entity.ModelConstants.SIM_PROVIDER;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.test_core.thingsboard.common.SimData;
import com.test_core.thingsboard.common.SimInfo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@AllArgsConstructor
//@TbCoreComponent
@Service
@Slf4j
public class DefaultTbSimDataServiceImpl  implements TbSimDataService {
	
	@Autowired
    SimDataService simDataService;
    private static Map<String, Map<String, Long>> metaDataTypeMap = new ConcurrentHashMap<>();

    @Override
    public SimData saveSimData(String deviceID, String meterId, String imsi, String simSerial, String serviceProvider, String phoneNo, Long serviceProviderId) throws Exception {
        SimData simData = new SimData();
        if (serviceProvider != null)
            simData.setServiceProviderId(getMetaDataId(SIM_PROVIDER, serviceProvider.toUpperCase()));
        serviceProviderId = simData.getServiceProviderId();
        if (serviceProviderId == null)
            throw new Exception("Service provider does not exist in system");//, ThingsboardErrorCode.GENERAL);
        if (simSerial != null)
            simData.setSimSerial(simSerial);
        if (imsi != null)
            simData.setImsi(imsi);
        if (phoneNo != null)
            simData.setPhoneNo(phoneNo);
        return simDataService.save(simData, deviceID, meterId);
    }


    public static Long getMetaDataId(String type, String name) {
        Long metaDataId = null;
        if (metaDataTypeMap.containsKey(type)) {
            Map<String, Long> typeMap = metaDataTypeMap.get(type);
            if (typeMap.containsKey(name))
                metaDataId = typeMap.get(name);
        }
        return metaDataId;
    }

	@Override
    public SimData save(SimInfo simInfo, BindingResult bindingResult) throws Exception {
        SimData simData = new SimData();
        if (bindingResult.hasErrors()) {
            List<String> errorMessages = bindingResult.getFieldErrors().stream()
                    .map(FieldError::getDefaultMessage)
                    .collect(Collectors.toList());
            throw new Exception();
        }
        simData.setServiceProviderId(getMetaDataId(SIM_PROVIDER, simInfo.getService_provider().toUpperCase()));
        if (simData.getServiceProviderId() == null)
            throw new Exception("Service provider does not exist in system");//, ThingsboardErrorCode.GENERAL);
        simData.setSimSerial(simInfo.getSim_serial());
        simData.setImsi(simInfo.getImsi());
        simData.setPhoneNo(simInfo.getPhone_no());
        return simDataService.save(simData, null, null);
    }
}
