package com.better.wust.dao;

import com.better.wust.entity.TransRecord;
import com.better.wust.tools.entity.SelectEntity;

import java.util.List;

public interface TransRecordDao {

    public List<TransRecord> selectAllTransRecords(SelectEntity selectEntity);

    public int selectTransRecordNumber(SelectEntity selectEntity);

    /**
     * 添加一个初始转换记录
     *
     * @param transRecord
     */
    public void insertTransRecord(TransRecord transRecord);







    /**
     * 添加一个销售转换记录
     *
     * @param transRecord
     */
    public void insertTransRecordSecond(TransRecord transRecord);

    public List<TransRecord> selectAllTransRecordsSecond(SelectEntity selectEntity);

    public int getTransRecordSecondNumber(SelectEntity selectEntity);
}
