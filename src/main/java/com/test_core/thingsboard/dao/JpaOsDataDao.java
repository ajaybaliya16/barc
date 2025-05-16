package com.test_core.thingsboard.dao;


import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test_core.thingsboard.entity.OSDataEntity;
import com.test_core.thingsboard.repo.OsDataRepository;

//@SqlDao
@Slf4j
@Component
public class JpaOsDataDao {

    @Autowired
    private OsDataRepository osDataRepository;

    public OSDataEntity save(OSDataEntity osDataEntity) {
        return osDataRepository.save(osDataEntity);
    }

}
