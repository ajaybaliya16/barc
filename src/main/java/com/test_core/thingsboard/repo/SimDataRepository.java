package com.test_core.thingsboard.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test_core.thingsboard.entity.SimDataEntity;

public interface SimDataRepository extends JpaRepository<SimDataEntity, Long> {
    @Query("SELECT s.id FROM SimDataEntity s WHERE s.imsi = :imsi")
    Long findSimDataIdBySimImsi(@Param("imsi") String imsi);

    SimDataEntity findByImsi(String imsi);

    SimDataEntity findBySimSerial(String simSerial);

    SimDataEntity findByPhoneNo(String phoneNo);

}
