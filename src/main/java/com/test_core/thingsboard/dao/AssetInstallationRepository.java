package com.test_core.thingsboard.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test_core.thingsboard.entity.AssetInstallationEntity;

public interface AssetInstallationRepository extends JpaRepository<AssetInstallationEntity, Long> {
    @Query(value = "SELECT hhid FROM barc.asset_installation_data WHERE meter_id = :meterId ORDER BY id DESC LIMIT 1;", nativeQuery = true)
    Long getHouseHoldIdByMeterId(@Param("meterId") Long meterId);
}
