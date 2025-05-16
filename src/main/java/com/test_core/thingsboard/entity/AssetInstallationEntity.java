package com.test_core.thingsboard.entity;

import static com.test_core.thingsboard.entity.ModelConstants.ASSET_INSTALLATION_DATA_TABLE_NAME;
import static com.test_core.thingsboard.entity.ModelConstants.BARC_SCHEMA;
import static com.test_core.thingsboard.entity.ModelConstants.CREATED_BY;
import static com.test_core.thingsboard.entity.ModelConstants.CREATED_TIME_PROPERTY;
import static com.test_core.thingsboard.entity.ModelConstants.FIELD_MODE;
import static com.test_core.thingsboard.entity.ModelConstants.HHID;
import static com.test_core.thingsboard.entity.ModelConstants.ID_PROPERTY;
import static com.test_core.thingsboard.entity.ModelConstants.IS_CONFIG;
import static com.test_core.thingsboard.entity.ModelConstants.METER_ID;
import static com.test_core.thingsboard.entity.ModelConstants.METER_INSTALLATION_STATUS_ID;
import static com.test_core.thingsboard.entity.ModelConstants.METER_REMARK;
import static com.test_core.thingsboard.entity.ModelConstants.M_INSTALLATION_ACTIVE_FROM;
import static com.test_core.thingsboard.entity.ModelConstants.M_INSTALLATION_ACTIVE_TO;
import static com.test_core.thingsboard.entity.ModelConstants.NEW_METER_ID;
import static com.test_core.thingsboard.entity.ModelConstants.OLD_METER_ID;
import static com.test_core.thingsboard.entity.ModelConstants.REMOTE_ID;
import static com.test_core.thingsboard.entity.ModelConstants.REMOTE_INSTALLATION_STATUS_ID;
import static com.test_core.thingsboard.entity.ModelConstants.REMOTE_REMARK;
import static com.test_core.thingsboard.entity.ModelConstants.R_PAIRING_ACTIVE_FROM;
import static com.test_core.thingsboard.entity.ModelConstants.R_PAIRING_ACTIVE_TO;
import static com.test_core.thingsboard.entity.ModelConstants.TV_ID;
import static com.test_core.thingsboard.entity.ModelConstants.UPDATED_BY_PROPERTY;
import static com.test_core.thingsboard.entity.ModelConstants.UPDATED_TIME_PROPERTY;
import static com.test_core.thingsboard.entity.ModelConstants.W_ID;

import java.sql.Timestamp;

import com.test_core.thingsboard.common.AssetInstallation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;


@Data
@Entity
//@TypeDef(name = "json", typeClass = JsonStringType.class)
@Table(schema = BARC_SCHEMA, name = ASSET_INSTALLATION_DATA_TABLE_NAME)
public class AssetInstallationEntity {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = ID_PROPERTY)
	    private Long id;
	    @Column(name = METER_INSTALLATION_STATUS_ID)
	    private Long meterInstallationStatusId;
	    @Column(name = REMOTE_INSTALLATION_STATUS_ID)
	    private Long remoteInstallationStatusId;
	    @Column(name = HHID)
	    private Long hhid;
	    @Column(name = METER_ID)
	    private Long meterId;
	    @Column(name = REMOTE_ID)
	    private Long remoteId;
	    @Column(name = TV_ID)
	    private Integer tvId;
	    @Column(name = W_ID)
	    private String wid;
	    @Column(name = FIELD_MODE)
	    private String fieldMode;
	    @Column(name = METER_REMARK)
	    private String meterRemark;
	    @Column(name = REMOTE_REMARK)
	    private String remoteRemark;
	    @Column(name = M_INSTALLATION_ACTIVE_FROM)
	    private Timestamp meterInstallationActiveFrom;
	    @Column(name = M_INSTALLATION_ACTIVE_TO)
	    private Timestamp meterInstallationActiveTo;
	    @Column(name = R_PAIRING_ACTIVE_FROM)
	    private Timestamp remotePairingActiveFrom;
	    @Column(name = R_PAIRING_ACTIVE_TO)
	    private Timestamp remotePairingActiveTo;
	    @Column(name = CREATED_BY)
	    private String createdBy;
	    @Column(name = UPDATED_BY_PROPERTY)
	    private String updatedBy;
	    @Column(name = UPDATED_TIME_PROPERTY)
	    private Timestamp updatedTime;
	    @Column(name = CREATED_TIME_PROPERTY)
	    private Timestamp createdTime;
	    @Column(name = OLD_METER_ID)
	    private Long oldMeterId;
	    @Column(name = IS_CONFIG)
	    private boolean isConfig;
	    @Column(name = NEW_METER_ID)
	    private Long newMeterId;

	    @Transient
	    private String meterHwVersion;

	    @Transient
	    private String remoteHwVersion;

	    @Transient
	    private String osType;

	    public AssetInstallationEntity() {
	        super();
	    }

	    public AssetInstallationEntity(AssetInstallation assetInstallation) {
	        if (assetInstallation.getId() != null)
	            this.setId(assetInstallation.getId());
	        this.setCreatedTime(assetInstallation.getCreatedTime());
	        this.hhid = Long.parseLong(assetInstallation.getHhid());
	        this.meterId = Long.parseLong(assetInstallation.getMeter_id());
	        this.remoteId = Long.parseLong(assetInstallation.getRemote_id());
	        this.tvId = Integer.parseInt(assetInstallation.getTv_id());
	        this.wid = assetInstallation.getWid();
//	        this.fieldMode = assetInstallation.getFieldMode();
	        this.meterInstallationStatusId = assetInstallation.getMeterInstallationStatusId();
	        this.remoteInstallationStatusId = assetInstallation.getRemoteInstallationStatusId();
	        this.meterInstallationActiveFrom = assetInstallation.getMeterInstallationActiveFrom();
	        this.meterInstallationActiveTo = assetInstallation.getMeterInstallationActiveTo();
	        this.remotePairingActiveFrom = assetInstallation.getRemotePairingActiveFrom();
	        this.remotePairingActiveTo = assetInstallation.getRemotePairingActiveTo();
	        this.meterRemark = assetInstallation.getRemark();
	        this.remoteRemark = assetInstallation.getRemoteRemark();
	        this.createdBy = assetInstallation.getCreatedBy();
	        this.updatedBy = assetInstallation.getUpdatedBy();
	        this.updatedTime = assetInstallation.getUpdatedTime();
	        this.isConfig = assetInstallation.isConfig();
	        this.oldMeterId = Long.parseLong(assetInstallation.getOld_meter_id());
	        this.newMeterId = Long.parseLong(assetInstallation.getNew_meter_id());
	    }

	    public AssetInstallationEntity(AssetInstallationEntity aie, String osType, String meterHwVersion, String remoteHwVersion) {
	        this(aie);
	        this.osType = osType;
	        this.meterHwVersion = meterHwVersion;
	        this.remoteHwVersion = remoteHwVersion;
	    }

	    public AssetInstallationEntity(AssetInstallationEntity assetInstallationEntity) {
	        this.setId(assetInstallationEntity.getId());
	        this.setCreatedTime(assetInstallationEntity.getCreatedTime());
	        this.hhid = assetInstallationEntity.getHhid();
	        this.meterId = assetInstallationEntity.getMeterId();
	        this.remoteId = assetInstallationEntity.getRemoteId();
	        this.tvId = assetInstallationEntity.getTvId();
	        this.wid = assetInstallationEntity.getWid();
	        this.fieldMode = assetInstallationEntity.getFieldMode();
	        this.meterInstallationStatusId = assetInstallationEntity.getMeterInstallationStatusId();
	        this.remoteInstallationStatusId = assetInstallationEntity.getRemoteInstallationStatusId();
	        this.meterInstallationActiveFrom = assetInstallationEntity.getMeterInstallationActiveFrom();
	        this.meterInstallationActiveTo = assetInstallationEntity.getMeterInstallationActiveTo();
	        this.remotePairingActiveFrom = assetInstallationEntity.getRemotePairingActiveFrom();
	        this.remotePairingActiveTo = assetInstallationEntity.getRemotePairingActiveTo();
	        this.meterRemark = assetInstallationEntity.getMeterRemark();
	        this.remoteRemark = assetInstallationEntity.getRemoteRemark();
	        this.createdBy = assetInstallationEntity.getCreatedBy();
	        this.updatedBy = assetInstallationEntity.getUpdatedBy();
	        this.updatedTime = assetInstallationEntity.getUpdatedTime();
	        this.oldMeterId = assetInstallationEntity.getOldMeterId();
	        this.isConfig = assetInstallationEntity.isConfig();
	        this.newMeterId = assetInstallationEntity.getNewMeterId();
	    }

		/*
		 * @Override public AssetInstallation toData() { AssetInstallation
		 * assetInstallation = new AssetInstallation(); assetInstallation.setId(id);
		 * assetInstallation.setHhid(String.valueOf(hhid));
		 * assetInstallation.setMeter_id(String.valueOf(meterId));
		 * assetInstallation.setMeterType(this.osType);
		 * assetInstallation.setRemote_id(String.valueOf(remoteId));
		 * assetInstallation.setTv_id(String.valueOf(tvId));
		 * assetInstallation.setWid(wid); // assetInstallation.setFieldMode(fieldMode);
		 * assetInstallation.setMeterInstallationStatusId(meterInstallationStatusId); if
		 * (this.meterInstallationStatusId != null)
		 * assetInstallation.setMeterInstallationStatus(getMetaDataName(this.
		 * meterInstallationStatusId));
		 * assetInstallation.setRemoteInstallationStatusId(remoteInstallationStatusId);
		 * if (this.remoteInstallationStatusId != null)
		 * assetInstallation.setRemoteInstallationStatus(getMetaDataName(this.
		 * remoteInstallationStatusId));
		 * assetInstallation.setMeterInstallationActiveFrom(meterInstallationActiveFrom)
		 * ; assetInstallation.setMeterInstallationActiveTo(meterInstallationActiveTo);
		 * assetInstallation.setRemotePairingActiveFrom(remotePairingActiveFrom);
		 * assetInstallation.setRemotePairingActiveTo(remotePairingActiveTo);
		 * assetInstallation.setRemark(meterRemark);
		 * assetInstallation.setRemoteRemark(remoteRemark);
		 * assetInstallation.setCreatedBy(createdBy);
		 * assetInstallation.setUpdatedBy(updatedBy);
		 * assetInstallation.setUpdatedTime(updatedTime);
		 * assetInstallation.setCreatedTime(createdTime);
		 * assetInstallation.setMeterHwVersion(meterHwVersion);
		 * assetInstallation.setRemoteHwVersion(remoteHwVersion);
		 * assetInstallation.setConfig(isConfig);
		 * assetInstallation.setOld_meter_id(String.valueOf(oldMeterId));
		 * assetInstallation.setNew_meter_id(String.valueOf(newMeterId));
		 * 
		 * return assetInstallation; }
		 */
}
