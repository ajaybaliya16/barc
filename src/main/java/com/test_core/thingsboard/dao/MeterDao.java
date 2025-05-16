package com.test_core.thingsboard.dao;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test_core.thingsboard.common.ThingsboardErrorCode;
import com.test_core.thingsboard.customException.ThingsboardException;
import com.test_core.thingsboard.entity.Meter;
import com.test_core.thingsboard.entity.MeterEntity;
import com.test_core.thingsboard.entity.MeterHistoryEntity;
import com.test_core.thingsboard.repo.MeterRepository;

@Service
public class MeterDao {

	@Autowired
	private MeterRepository meterRepository;

	@Autowired
	private MeterHistoryRepository meterHistoryRepository;

	public Meter findByDeviceId(String deviceId) {
		return DaoUtil.getData(meterRepository.findByDeviceId(deviceId));
	}

	public Meter saveMeter(Meter meter) {

		return DaoUtil.getData(meterRepository.save(new MeterEntity(meter)));
	}

	private void saveMeterHistoryEntity(Long meterId, Long statusId, String remark, Timestamp timestamp,
			String userName) {
		MeterHistoryEntity meterHistoryEntity = new MeterHistoryEntity();
		meterHistoryEntity.setMeterId(meterId);
		meterHistoryEntity.setValidFrom(timestamp);
		meterHistoryEntity.setStatusId(statusId);
		meterHistoryEntity.setRemark(remark);
		meterHistoryEntity.setCreatedBy(userName);
		meterHistoryRepository.save(meterHistoryEntity);
	}

	public void saveOrUpdateMeterHistoryEntity(boolean isUpdate, String userName, Long meterId, Long statusId,
			String remark) throws ThingsboardException {
		try {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			if (isUpdate) {
				MeterHistoryEntity existingMeterHistoryEntity = meterHistoryRepository
						.findLatestMeterHistoryEntity(meterId);
				if (existingMeterHistoryEntity != null) {
					existingMeterHistoryEntity.setUpdatedBy(userName);
					existingMeterHistoryEntity.setValidTo(timestamp);
					meterHistoryRepository.save(existingMeterHistoryEntity);
				}
			}
			saveMeterHistoryEntity(meterId, statusId, remark, timestamp, userName);
		} catch (Exception e) {
			throw new ThingsboardException(e.getMessage(), ThingsboardErrorCode.GENERAL);
		}
	}

	public Meter saveOrUpdateMeter(Meter meter, boolean isUpdate, String userName) throws ThingsboardException {
		try {
			Meter meterData = DaoUtil.getData(meterRepository.save(new MeterEntity(meter)));
			if (meterData != null) {
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				if (isUpdate) {
					MeterHistoryEntity existingMeterHistoryEntity = meterHistoryRepository
							.findLatestMeterHistoryEntity(meterData.getMeterId());
					if (existingMeterHistoryEntity != null) {
						existingMeterHistoryEntity.setUpdatedBy(meterData.getUpdatedBy());
						existingMeterHistoryEntity.setValidTo(timestamp);
						meterHistoryRepository.save(existingMeterHistoryEntity);
					}
				}
				saveOrUpdateMeterHistoryEntity(isUpdate, userName, meter.getMeterId(), meter.getStatusId(),
						meter.getRemark());
				return meterData;
			} else
				throw new ThingsboardException("Error Occurred while saving or updating the Meter data",
						ThingsboardErrorCode.GENERAL);
		} catch (Exception e) {
			throw new ThingsboardException(e.getMessage(), ThingsboardErrorCode.GENERAL);
		}
	}
}
