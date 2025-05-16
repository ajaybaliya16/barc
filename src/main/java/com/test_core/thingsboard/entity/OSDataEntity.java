package com.test_core.thingsboard.entity;


import static com.test_core.thingsboard.entity.ModelConstants.*;

import java.util.List;

import org.hibernate.annotations.Type;

import com.test_core.thingsboard.common.OsData;
import com.test_core.thingsboard.dao.ToData;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
//@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@Entity
@Table(schema = BARC_SCHEMA, name = OS_DATA)
public class OSDataEntity {//implements ToData<OsData> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ID_PROPERTY)
    private Long id;
    @Column(name = OS_TYPE)
    private String osType;
    @Column(name = HARDWARE_VERSION)
    private String hardwareVersion;
//    @Type(type = "jsonb")
    @Column(name = CONFLICTED_COMPONENTS, columnDefinition = "jsonb")
    private List<String> conflictedComponents;
//    @Type(type = "jsonb")
    @Column(name = MANDATORY_PARAMS, columnDefinition = "jsonb")
    private List<String> mandatoryParams;

    public OSDataEntity() {
        super();
    }

    public OSDataEntity(OsData osData) {
        if (osData.getId() != null)
            this.setId(osData.getId());
        this.osType = osData.getOsType();
        this.hardwareVersion = osData.getHardwareVersion();
        this.mandatoryParams = osData.getMandatoryParams();
        this.conflictedComponents = osData.getConflictedComponents();
    }

//    @Override
//    public OsData toData() {
//        OsData osData = new OsData();
//        osData.setId(this.id);
//        osData.setOsType(this.osType);
//        osData.setHardwareVersion(this.hardwareVersion);
//        osData.setMandatoryParams(this.mandatoryParams);
//        osData.setConflictedComponents(this.conflictedComponents);
//        return osData;
//    }

}
