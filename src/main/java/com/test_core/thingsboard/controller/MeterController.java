package com.test_core.thingsboard.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test_core.thingsboard.service.MeterService;
import com.test_core.thingsboard.service.TbMeterService;
@RestController
//@TbCoreComponent
@RequestMapping("/api")
//@RequiredArgsConstructor
public class MeterController {


//    private final MeterService meterService;
    
//    private final
	@Autowired
    TbMeterService tbMeterService;

//    @Autowired
//    public MeterController(MeterService meterService,TbMeterService tbMeterService) {
//        this.meterService = meterService;
//        this.tbMeterService=tbMeterService;
//    }
	
//    @ApiOperation(value = "Signup Device", notes = "Signup Device.")
    @PostMapping(value = "/signupdevice")
    public ResponseEntity signupdevice(@RequestParam("deviceID") String deviceID,
                                       @RequestParam("lat") Double lat,
                                       @RequestParam("lng") Double lng,
                                       @RequestParam("meterId") String meterId,
                                       @RequestParam("deviceSerialNumber") String deviceSerialNumber,
                                       @RequestParam("assetSerialNumber") String assetSerialNumber,
                                       @RequestParam("simSerialNumber") String simSerialNumber,
                                       @RequestParam("imeiNumber1") String imeiNumber1,
                                       @RequestParam("imeiNumber2") String imeiNumber2,
                                       @RequestParam("simOperator") String simOperator,
                                       @RequestParam("networkOperator") String networkOperator,
                                       @RequestParam("networkOperatorName") String networkOperatorName,
                                       @RequestParam("osVersion") String osVersion,
                                       @RequestParam("appVersion") String appVersion,
                                       @RequestParam("simOperatorName") String simOperatorName,
                                       @RequestParam(value = "EthernetMAC", required = false) String ethMac,
                                       @RequestParam(value = "MotherBoardSNo", required = false) String motherBoardSerialNo,
                                       @RequestParam(value = "IMSI", required = false) String imsi) throws Exception {
        if (deviceID == null) {
//            log.error("Invalid request: DeviceID should not be null or empty");
            throw new Exception("Invalid request: deviceID should not be null or empty ");
        }
        tbMeterService.signupdevice(deviceID, lat, lng, meterId, deviceSerialNumber, assetSerialNumber, simSerialNumber, imeiNumber1, imeiNumber2, simOperator, networkOperator, networkOperatorName, osVersion, appVersion, ethMac, motherBoardSerialNo, imsi, simOperatorName);
        return new ResponseEntity<>("Device created", HttpStatus.OK);
    }

//    @ApiOperation(value = "Get Device Licence Key", notes = "Get Device Licence Key.")
    @GetMapping(value = "/getdevicelicensekey")
    public ResponseEntity getdevicelicensekey(@RequestParam("deviceID") String deviceID) throws Exception {
        if (deviceID == null) {
//            log.error("Invalid request: DeviceID should not be null or empty");
            throw new Exception("Invalid request: DeviceID should not be null or empty ");
        }
        String licenseKey = tbMeterService.getdevicelicensekey(deviceID);
        Map<String, Object> response = new HashMap<>();
        if (licenseKey != null) {
            response.put("license", licenseKey);
            response.put("success", true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("success", false);
            response.put("message", "Device does not exists. Please Try Again With Valid Device ID.");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

//    @ApiOperation(value = "Generate Device License key", notes = "Generate Device License key.")
    @GetMapping(value = "/generatedevicelicensekey")
    public ResponseEntity generatedevicelicensekey(@RequestParam("deviceID") String deviceID) throws Exception {
        if (deviceID == null) {
//            log.error("Invalid request: DeviceID should not be null or empty");
            throw new Exception("Invalid request: DeviceID should not be null or empty ");//, ThingsboardErrorCode.BAD_REQUEST_PARAMS);
        }
        String licenseKey = tbMeterService.generatedevicelicensekey(deviceID);
        Map<String, Object> response = new HashMap<>();
        if (licenseKey != null) {
            response.put("license", licenseKey);
            response.put("success", true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("success", false);
            response.put("message", "Device does not exists. Please Try Again With Valid Device ID.");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }


}
