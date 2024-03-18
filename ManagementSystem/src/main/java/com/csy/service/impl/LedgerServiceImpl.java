package com.csy.service.impl;

import com.csy.entity.Ledger;
import com.csy.entity.Products;
import com.csy.mapper.LedgerMapper;
import com.csy.service.LedgerService;
import com.csy.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LedgerServiceImpl implements LedgerService {

    @Resource
    LedgerMapper ledgerMapper;
    /**
     *
     * @param sid
     * @param id
     * @param specification
     * 通过店铺ID获取店铺信息和商品信息以及数量，然后进行商品出库，更新商品信息
     * @return
     */
    //出库 入库
    @Override
    public Result shipOut(int id, String specification, int sid,int type) {
        Result result = new Result<>();
        ledgerMapper.shipOut(id, specification, sid, type);
        List<Ledger> ledgerList = ledgerMapper.querys(sid, id);
        long count1 = ledgerList.stream().filter(x -> x.getType() == 0).map(x -> x.getQuantity()).count();//入库
        long count2 = ledgerList.stream().filter(x -> x.getType() == 1).map(x -> x.getQuantity()).count();//出库
        long total = count1 - count2;
        result.setData(total);
        return result;
    }

    @Override
    public Result queryjilu(List<Integer> ids, Date date, int page, int limit) {
        Result<Object> result = new Result<>();

        int offset = (page - 1) * limit;
        List<Ledger> ledgerList = ledgerMapper.findAllLedger(ids, date, offset, limit);
        int count = ledgerMapper.CountSelectAll();
        int total = count / limit;
        result.setTotal(total);
        result.setData(ledgerList);
        result.setPage(page);
        result.setSize(limit);
        return result;
    }


}
