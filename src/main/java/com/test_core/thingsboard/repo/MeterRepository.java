package com.test_core.thingsboard.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test_core.thingsboard.entity.MeterEntity;

public interface MeterRepository extends JpaRepository<MeterEntity, Long> {
    MeterEntity findByMeterId(Long meterId);

    MeterEntity findByDeviceId(String deviceId);
    
    @Query("SELECT m FROM MeterEntity m WHERE m.sim1ImsiId = :simImsiId OR m.sim2ImsiId =:simImsiId")
    MeterEntity findByImsiId(@Param("simImsiId") Long simImsiId);
    

}
