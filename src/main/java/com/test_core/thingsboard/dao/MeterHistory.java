package com.test_core.thingsboard.dao;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeterHistory {
	private Long id;

    private Long meterId;

    private Timestamp validfrom;

    private Timestamp validTo;

    private Long statusId;

    private String remark;

    private String updatedBy;

    private String createdBy;

    private String status;
}
