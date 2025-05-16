package com.test_core.thingsboard.common;

import java.sql.Timestamp;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssetInstallation {
	 private Long id;
	    private String meterType = "ANDROID";
	    private Long meterInstallationStatusId;
	    private Long remoteInstallationStatusId;
	    private String hhid;
	    private String meter_id;
	    private String remote_id;
	    private String tv_id;
	    private String wid;
	    private String fieldMode;
	    private Timestamp meterInstallationActiveFrom;
	    private Timestamp meterInstallationActiveTo;
	    private String remark;
	    private Timestamp remotePairingActiveFrom;
	    private Timestamp remotePairingActiveTo;
	    private String remoteRemark;
	    private String createdBy;
	    private String updatedBy;
	    private Timestamp updatedTime;
	    private String old_meter_id;
	    private Long oldRemoteId;
	    private Timestamp createdTime;
	    private String meterHwVersion;
	    private String remoteHwVersion;
	    private boolean isConfig;
	    private String new_meter_id;
	    private String meterInstallationStatus;
	    private String remoteInstallationStatus;

//	    public AssetInstallation(Long id, Long meterId, Long hhid, Integer tvId, Long remoteId, String wid, String fieldMode,
//	                             Long meterInstallationStatusId, Timestamp meterInstallationActiveFrom, Timestamp meterInstallationActiveTo,
//	                             Long remoteInstallationStatusId, Timestamp remotePairingActiveFrom, Timestamp remotePairingActiveTo,
//	                             String meterRemark, String remoteRemark, String createdBy, String updatedBy, Timestamp updatedTime,
//	                             Timestamp createdTime, Long oldMeterId, boolean isConfig, Long newMeterId, String meterInstallationStatus,
//	                             String remoteInstallationStatus, String meterType, String meterHwVersion, String remoteHwVersion){
	//
//	    }


	    public AssetInstallation(Long id, String meter_id, String hhid, String tv_id, String remote_id, String wid, String fieldMode,
	                             Long meterInstallationStatusId, Timestamp meterInstallationActiveFrom, Timestamp meterInstallationActiveTo,
	                             Long remoteInstallationStatusId, Timestamp remotePairingActiveFrom, Timestamp remotePairingActiveTo,
	                             String remark, String remoteRemark, String createdBy, String updatedBy, Timestamp updatedTime,
	                             Timestamp createdTime, String old_meter_id, boolean isConfig, String new_meter_id, String meterInstallationStatus,
	                             String remoteInstallationStatus, String meterType, String meterHwVersion, String remoteHwVersion) {
	        this.id = id;
	        this.meterType = meterType;
	        this.hhid = hhid;
	        this.meterInstallationStatusId = meterInstallationStatusId;
	        this.remoteInstallationStatusId = remoteInstallationStatusId;
	        this.meter_id = meter_id;
	        this.remote_id = remote_id;
	        this.tv_id = tv_id;
	        this.wid = wid;
	        this.updatedBy = updatedBy;
	        this.fieldMode = fieldMode;
	        this.meterInstallationActiveFrom = meterInstallationActiveFrom;
	        this.meterInstallationActiveTo = meterInstallationActiveTo;
	        this.remark = remark;
	        this.remotePairingActiveFrom = remotePairingActiveFrom;
	        this.remotePairingActiveTo = remotePairingActiveTo;
	        this.remoteRemark = remoteRemark;
	        this.createdBy = createdBy;
	        this.updatedTime = updatedTime;
	        this.old_meter_id = old_meter_id;
	        this.createdTime = createdTime;
	        this.meterHwVersion = meterHwVersion;
	        this.remoteHwVersion = remoteHwVersion;
	        this.isConfig = isConfig;
	        this.new_meter_id = new_meter_id;
	        this.meterInstallationStatus = meterInstallationStatus;
	        this.remoteInstallationStatus = remoteInstallationStatus;
	    }
}
