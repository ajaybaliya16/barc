package com.test_core.thingsboard.entity;

import static com.test_core.thingsboard.dao.DataUtils.*;
import static com.test_core.thingsboard.entity.ModelConstants.BARC_SCHEMA;
import static com.test_core.thingsboard.entity.ModelConstants.ID_PROPERTY;
import static com.test_core.thingsboard.entity.ModelConstants.PHONE_NO;
import static com.test_core.thingsboard.entity.ModelConstants.SERVICE_PROVIDER_ID;
import static com.test_core.thingsboard.entity.ModelConstants.SIM_DATA_TABLE_NAME;
import static com.test_core.thingsboard.entity.ModelConstants.SIM_SERIAL;

import com.test_core.thingsboard.common.SimData;
import com.test_core.thingsboard.dao.ToData;

//import javax.persistence.*;

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
@Table(schema = BARC_SCHEMA, name = SIM_DATA_TABLE_NAME)
public class SimDataEntity implements ToData<SimData> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ID_PROPERTY)
    private Long id;
    private String imsi;
    @Column(name = SIM_SERIAL)
    private String simSerial;
    @Column(name = SERVICE_PROVIDER_ID)
    private Long serviceProviderId;
    @Column(name = PHONE_NO)
    private String phoneNo;

    public SimDataEntity(SimData simData) {
        if (simData.getId() != null)
            this.setId(simData.getId());
        this.imsi = simData.getImsi();
        this.simSerial = simData.getSimSerial();
        this.serviceProviderId = simData.getServiceProviderId();
        this.phoneNo = simData.getPhoneNo();
    }

    @Override
    public SimData toData() {
        SimData simData = new SimData();
        simData.setId(this.id);
        simData.setImsi(this.imsi);
        simData.setSimSerial(this.simSerial);
        simData.setServiceProviderId(this.serviceProviderId);
        if (this.serviceProviderId != null)
            simData.setServiceProvider(getMetaDataName(this.serviceProviderId));
        simData.setPhoneNo(this.phoneNo);
        return simData;
    }
}
