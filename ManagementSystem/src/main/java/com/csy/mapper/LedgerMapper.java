package com.csy.mapper;

import com.csy.entity.Ledger;
import com.csy.utils.Result;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

@Mapper
public interface LedgerMapper {

    //出库
    int StoProductNum(int sid,int id,String specification);

    int shipOut(int id, String specification, int sid,int type);

    List< Ledger> querys(int sid, int pid);

    List<Ledger> findAllLedger(@Param("ids") List<Integer> ids, Date date, int offset, int limit);

    int CountSelectAll();
}
