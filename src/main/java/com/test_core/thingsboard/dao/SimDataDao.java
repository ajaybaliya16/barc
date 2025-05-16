package com.test_core.thingsboard.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test_core.thingsboard.common.SimData;
import com.test_core.thingsboard.entity.SimDataEntity;
import com.test_core.thingsboard.repo.SimDataRepository;

@Component
//@SqlDao
public class SimDataDao {
    @Autowired
    private SimDataRepository simDataRepository;

    public SimData save(SimData simData) {
        return DaoUtil.getData(simDataRepository.save(new SimDataEntity(simData)));
    }

}