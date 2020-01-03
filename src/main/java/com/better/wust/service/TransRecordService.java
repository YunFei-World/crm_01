package com.better.wust.service;

import com.better.wust.entity.TransRecord;
import com.better.wust.tools.entity.SelectEntity;

import java.util.List;

public interface TransRecordService {
    public List<TransRecord> findAllTransRecords(SelectEntity selectEntity);

    public int getTransRecordNumber(SelectEntity selectEntity);

    public List<TransRecord> findAllTransRecordsSecond(SelectEntity selectEntity);

    public int getTransRecordSecondNumber(SelectEntity selectEntity);
}
