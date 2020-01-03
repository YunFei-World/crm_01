package com.better.wust.service.Impl;

import com.better.wust.dao.TransRecordDao;
import com.better.wust.entity.TransRecord;
import com.better.wust.service.TransRecordService;
import com.better.wust.tools.entity.SelectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TransRecordServiceImpl implements TransRecordService {

    @Autowired
    private TransRecordDao transRecordDao;

    @Override
    public List<TransRecord> findAllTransRecords(SelectEntity selectEntity) {
        return transRecordDao.selectAllTransRecords(selectEntity);
    }

    @Override
    public int getTransRecordNumber(SelectEntity selectEntity) {
        return transRecordDao.selectTransRecordNumber(selectEntity);
    }


    @Override
    public List<TransRecord> findAllTransRecordsSecond(SelectEntity selectEntity) {
        return transRecordDao.selectAllTransRecordsSecond(selectEntity);
    }

    @Override
    public int getTransRecordSecondNumber(SelectEntity selectEntity) {
        return transRecordDao.getTransRecordSecondNumber(selectEntity);
    }
}
