package com.test_core.thingsboard.service;

import static com.test_core.thingsboard.dao.DaoUtil.getMetaDataId;
import static com.test_core.thingsboard.entity.ModelConstants.SIM_PROVIDER;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.test_core.thingsboard.common.SimData;
import com.test_core.thingsboard.common.SimInfo;
import com.test_core.thingsboard.common.ThingsboardErrorCode;
import com.test_core.thingsboard.customException.ThingsboardException;
import com.test_core.thingsboard.dao.SimDataService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Service
@Slf4j
public class DefaultTbSimDataServiceImpl implements TbSimDataService {
	
	private final SimDataService simDataService;

	    @Override
	    public SimData saveSimData(String deviceID, String meterId, String imsi, String simSerial, String serviceProvider, String phoneNo, Long serviceProviderId) throws ThingsboardException {
	        SimData simData = new SimData();
	        if (!Strings.isEmpty(serviceProvider))
	            simData.setServiceProviderId(getMetaDataId(SIM_PROVIDER, serviceProvider.toUpperCase()));
	        serviceProviderId = simData.getServiceProviderId();
	        if (serviceProviderId == null)
	            throw new ThingsboardException("Service provider does not exist in system", ThingsboardErrorCode.GENERAL);
	        if (simSerial != null)
	            simData.setSimSerial(simSerial);
	        if (!Strings.isEmpty(imsi))
	            simData.setImsi(imsi);
	        if (!Strings.isEmpty(phoneNo))
	            simData.setPhoneNo(phoneNo);
	        return simDataService.save(simData, deviceID, meterId);
	    }

	    @Override
	    public SimData save(SimInfo simInfo, BindingResult bindingResult) throws ThingsboardException {
	        SimData simData = new SimData();
	        if (bindingResult.hasErrors()) {
	            List<String> errorMessages = bindingResult.getFieldErrors().stream()
	                    .map(FieldError::getDefaultMessage)
	                    .collect(Collectors.toList());
	            throw new ThingsboardException(errorMessages);
	        }
	        simData.setServiceProviderId(getMetaDataId(SIM_PROVIDER, simInfo.getService_provider().toUpperCase()));
	        if (simData.getServiceProviderId() == null)
	            throw new ThingsboardException("Service provider does not exist in system", ThingsboardErrorCode.GENERAL);
	        simData.setSimSerial(simInfo.getSim_serial());
	        simData.setImsi(simInfo.getImsi());
	        simData.setPhoneNo(simInfo.getPhone_no());
	        return simDataService.save(simData, null, null);
	    }
}
