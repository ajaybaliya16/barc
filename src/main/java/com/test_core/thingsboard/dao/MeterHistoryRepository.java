package com.test_core.thingsboard.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test_core.thingsboard.entity.MeterHistoryEntity;

public interface MeterHistoryRepository extends JpaRepository<MeterHistoryEntity, Long> {
    @Query(value = "SELECT * FROM barc.meter_history m where m.meter_id=:meterId ORDER BY m.id DESC LIMIT 1", nativeQuery = true)
    MeterHistoryEntity findLatestMeterHistoryEntity(@Param("meterId") Long meterId);
}
