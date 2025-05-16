package com.test_core.thingsboard.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test_core.thingsboard.entity.OSDataEntity;

import java.util.List;

public interface OsDataRepository extends JpaRepository<OSDataEntity, Long> {

    @Query("SELECT os FROM OSDataEntity os")
    List<OSDataEntity> findOSType();

}
