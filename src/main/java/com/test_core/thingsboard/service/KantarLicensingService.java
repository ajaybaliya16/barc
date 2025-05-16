//package com.test_core.thingsboard.service;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import com.test_core.thingsboard.common.HttpsMeterLicenseParameters;
//import com.test_core.thingsboard.common.HttpsMeterLicenseRequest;
//import com.test_core.thingsboard.common.KantarLicense;
//import com.test_core.thingsboard.common.LicenseRequest;
//import com.test_core.thingsboard.common.LicenseResponse;
//import com.test_core.thingsboard.common.Metadata;
//import com.test_core.thingsboard.common.Parameters;
//import com.test_core.thingsboard.dao.JpaOsDataDao;
//
//@Service
//public class KantarLicensingService {
//
//    @Value("${kantar.basepath}")
//    private String basepath;
//
//    @Value("${kantar.android.username}")
//    private String androidUsername;
//
//    @Value("${kantar.android.password}")
//    private String androidPassword;
//
//    @Value("${kantar.android.type}")
//    private String androidType;
//
//    @Value("${kantar.android.pool}")
//    private String androidPool;
//
//    @Value("${kantar.android.lock_password}")
//    private boolean androidLockPassword;
//
//    @Value("${kantar.android.metadata.comment}")
//    private String androidComment;
//
//    @Value("${kantar.android.metadata.version}")
//    private String androidVersion;
//
//    @Value("${kantar.android.metadata.customer}")
//    private String androidCustomer;
//
//    @Value("${kantar.android.metadata.custom_metadata}")
//    private String androidCustomMetadata;
//
//    @Value("${kantar.linux.username}")
//    private String linuxUsername;
//
//    @Value("${kantar.linux.password}")
//    private String linuxPassword;
//
//    @Value("${kantar.linux.type}")
//    private String linuxType;
//
//    @Value("${kantar.linux.pool}")
//    private String linuxPool;
//
//    @Value("${kantar.linux.lock_password}")
//    private boolean linuxLockPassword;
//
//    @Value("${kantar.linux.lock_mac}")
//    private boolean linuxLockMac;
//
//    @Value("${kantar.linux.metadata.comment}")
//    private String linuxComment;
//
//    @Value("${kantar.linux.metadata.custom_metadata}")
//    private String linuxCustomMetadata;
//
//    @Value("${kantar.linux.metadata.customer}")
//    private String linuxCustomer;
//
//    @Value("${kantar.linux.metadata.version}")
//    private String linuxVersion;
//
////    private final 
//    
//    @Autowired
//    RestTemplate restTemplate;
//
////    public KantarLicensingService(RestTemplate restTemplate, JpaOsDataDao jpaOsTypeDao) {
////        this.restTemplate = restTemplate;
////    }
//
//    private String getAccessToken(String username, String password) {
//        String url = basepath + "online/logon";
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        Map<String, String> body = new HashMap<>();
//        body.put("login", username);
//        body.put("password", password);
//        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(body, headers);
//        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Map.class);
//        Map<String, String> responseBody = response.getBody();
//        return responseBody != null ? responseBody.get("token") : null;
//    }
//
//
//    public KantarLicense createLicense(Long osTypeId, String authCode) throws Exception {
//        String url = basepath + "licenses";
//        LicenseResponse response;
//        if (osTypeId == null)
//            throw new Exception("Unable to create licence for meter :OS Type not specified");//, ThingsboardErrorCode.ITEM_NOT_FOUND);
//
//        HttpHeaders headers = new HttpHeaders();
//
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        if (osTypeId.equals(37L)) {
//
//            headers.set("x-access-token", getAccessToken(linuxUsername, linuxPassword));
//            HttpEntity<LicenseRequest> licenseRequest = prepareLinuxRequest(authCode, headers);
//            response = restTemplate.postForObject(url, licenseRequest, LicenseResponse.class);
//        } else if (osTypeId.equals(38L)) {
//            headers.set("x-access-token", getAccessToken(androidUsername, androidPassword));
//            HttpEntity<HttpsMeterLicenseRequest> licenseRequest = prepareAndroidRequest(authCode, headers);
//            response = restTemplate.postForObject(url, licenseRequest, LicenseResponse.class);
//        } else
//            throw new Exception("Unable to create licence for meter :Unsupported OS Type ");//, ThingsboardErrorCode.GENERAL);
//        if (response != null)
//            return response.getResult();
//        else
//            throw new Exception("License creation failed");//, ThingsboardErrorCode.GENERAL);
//    }
//
//    private HttpEntity<LicenseRequest> prepareLinuxRequest(String authCode, HttpHeaders headers) {
//        Metadata metadata = new Metadata();
//        metadata.setCustomer(linuxCustomer);
//        metadata.setComment(linuxComment);
//        metadata.setVersion(linuxVersion);
//        metadata.setCustomMetaData(linuxCustomMetadata);
//
//        Parameters parameters = new Parameters();
//        parameters.setMetadata(metadata);
//        parameters.setLockMac(linuxLockMac);
//        parameters.setAuthorizationCode(authCode);
//        parameters.setLockPassword(linuxLockPassword);
//
//        LicenseRequest request = new LicenseRequest();
//        request.setType(linuxType);
//        request.setPool(linuxPool);
//        request.setParameters(parameters);
//        return new HttpEntity<>(request, headers);
//    }
//
//    private HttpEntity<HttpsMeterLicenseRequest> prepareAndroidRequest(String authCode, HttpHeaders headers) {
//
//        Metadata metadata = new Metadata();
//        metadata.setCustomer(androidCustomer);
//        metadata.setComment(androidComment);
//        metadata.setVersion(androidVersion);
//        metadata.setCustomMetaData(androidCustomMetadata);
//
//        HttpsMeterLicenseParameters parameters = new HttpsMeterLicenseParameters();
//        parameters.setMetadata(metadata);
//        parameters.setAuthorizationCode(authCode);
//        parameters.setLockPassword(androidLockPassword);
//
//        HttpsMeterLicenseRequest request = new HttpsMeterLicenseRequest();
//        request.setType(androidType);
//        request.setPool(androidPool);
//        request.setParameters(parameters);
//
//        return new HttpEntity<>(request, headers);
//    }
//}
//
