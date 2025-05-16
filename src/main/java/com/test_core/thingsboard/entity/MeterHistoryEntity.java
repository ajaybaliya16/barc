package com.test_core.thingsboard.entity;

import static com.test_core.thingsboard.dao.DataUtils.getMetaDataName;
import static com.test_core.thingsboard.entity.ModelConstants.BARC_SCHEMA;
import static com.test_core.thingsboard.entity.ModelConstants.CREATED_BY;
import static com.test_core.thingsboard.entity.ModelConstants.ID_PROPERTY;
import static com.test_core.thingsboard.entity.ModelConstants.METER_HISTORY_TABLE_NAME;
import static com.test_core.thingsboard.entity.ModelConstants.METER_ID;
import static com.test_core.thingsboard.entity.ModelConstants.REMARK;
import static com.test_core.thingsboard.entity.ModelConstants.STATUS_ID;
import static com.test_core.thingsboard.entity.ModelConstants.UPDATED_BY;
import static com.test_core.thingsboard.entity.ModelConstants.VALID_FROM_TIME_PROPERTY;
import static com.test_core.thingsboard.entity.ModelConstants.VALID_TO_TIME_PROPERTY;

import java.sql.Timestamp;

import com.test_core.thingsboard.dao.MeterHistory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(schema = BARC_SCHEMA, name = METER_HISTORY_TABLE_NAME)
public class MeterHistoryEntity {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = ID_PROPERTY)
	    private Long id;

	    @Column(name = METER_ID)
	    private Long meterId;

	    @Column(name = VALID_FROM_TIME_PROPERTY)
	    private Timestamp validFrom;

	    @Column(name = VALID_TO_TIME_PROPERTY)
	    private Timestamp validTo;

	    @Column(name = STATUS_ID)
	    private Long statusId;

	    @Column(name = REMARK)
	    private String remark;

	    @Column(name = UPDATED_BY)
	    private String updatedBy;

	    @Column(name = CREATED_BY)
	    private String createdBy;

	    public MeterHistory toData() {
	        MeterHistory meterHistory = new MeterHistory();
	        meterHistory.setId(id);
	        meterHistory.setMeterId(meterId);
	        meterHistory.setValidfrom(validFrom);
	        meterHistory.setValidTo(validTo);
	        meterHistory.setStatusId(statusId);
	        meterHistory.setStatus(getMetaDataName(statusId));
	        meterHistory.setRemark(remark);
	        meterHistory.setUpdatedBy(updatedBy);
	        meterHistory.setCreatedBy(createdBy);
	        return meterHistory;
	    }
}
