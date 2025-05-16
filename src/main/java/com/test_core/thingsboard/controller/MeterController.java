package com.test_core.thingsboard.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test_core.thingsboard.common.ThingsboardErrorCode;
import com.test_core.thingsboard.customException.ThingsboardException;
import com.test_core.thingsboard.service.TbMeterService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class MeterController {

	@Autowired
	private TbMeterService tbMeterService;

	@ApiOperation(value = "Save app latest version", notes = "Save app latest version.")
	@PostMapping(value = "/saveapplatestversion")
	public ResponseEntity saveapplatestversion(@RequestParam("appVersion") String appVersion,
			@RequestParam("appUpdatedDate") String appUpdatedDate, @RequestParam("deviceID") String deviceID)
			throws Exception {

		if (Strings.isEmpty(deviceID) || Strings.isEmpty(appUpdatedDate) || Strings.isEmpty(appVersion)) {
			log.error("Invalid request: AppUpdatedDate, AppVersion and DeviceID should not be null or empty");
			throw new ThingsboardException(
					"Invalid request: DeviceID, AppVersion and AppUpdatedDate should not be null or empty ",
					ThingsboardErrorCode.BAD_REQUEST_PARAMS);

		}
		String version = tbMeterService.saveapplatestversion(deviceID, appVersion, appUpdatedDate);
		Map<String, Object> response = new HashMap<>();
		if (version != null) {
			response.put("version", version);
			response.put("success", true);
			response.put("Last Updated Date", LocalDateTime.now().toString());
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.put("success", true);
			response.put("message", "Device does not exists. Please Try Again With Valid Device ID.");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
    @ApiOperation(value = "Get Meter ID", notes = "Get Meter ID.")
    @GetMapping(value = "/getmeterid")
    public ResponseEntity getmeterid(@RequestParam("MotherBoardSNo") String motherBoardSerialNo, @RequestParam("EthernetMAC") String ethMac, @RequestParam("deviceID") String deviceID) throws ThingsboardException {
        if (Strings.isEmpty(deviceID) || Strings.isEmpty(motherBoardSerialNo) || Strings.isEmpty(ethMac)) {
            log.error("Invalid request: DeviceID, EthMac and MotherBoardSerialNo  should not be null or empty");
            throw new ThingsboardException("Invalid request: DeviceID, EthMac and  MotherBoardSerialNo not be null or empty ", ThingsboardErrorCode.BAD_REQUEST_PARAMS);
        }
        Map<String, Object> response = tbMeterService.getmeterid(deviceID, motherBoardSerialNo, ethMac);
        if (!response.isEmpty()) {
            response.put("success", true);
            response.put("currentTimestamp", LocalDateTime.now().toString());
            response.put("currentTimestampInMillis", System.currentTimeMillis());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("success", true);
            response.put("currentTimestamp", LocalDateTime.now().toString());
            response.put("message", "Ethernet MAC address or MotherboardSerial No or DeviceID does not exists. Please Try Again With Valid Values.");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
    @ApiOperation(value = "Update printed meterid", notes = "Update printed meterid.")
    @PutMapping(value = "/updateprintedmeterid")
    public ResponseEntity updateprintedmeterid(@RequestParam("deviceID") String deviceID, @RequestParam("printedMeterId") String printedMeterId) throws ThingsboardException {
        if (Strings.isEmpty(deviceID) || Strings.isEmpty(printedMeterId)) {
            log.error("Invalid request: DeviceID, PrintedMeterId should not be null or empty");
            throw new ThingsboardException("Invalid request: DeviceID, PrintedMeterId should not be null or empty ", ThingsboardErrorCode.BAD_REQUEST_PARAMS);
        }
        String updateMeterid = tbMeterService.updateprintedmeterid(deviceID, printedMeterId);
        Map<String, Object> response = new HashMap<>();
        if (updateMeterid != null) {
            response.put("printed meterid", updateMeterid);
            response.put("success", true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("success", false);
            response.put("currentTimestamp", LocalDateTime.now().toString());
            response.put("message", "Device does not exists. Please Try Again With Valid Device ID.");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

}
