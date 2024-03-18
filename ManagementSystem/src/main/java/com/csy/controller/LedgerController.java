package com.csy.controller;

import com.csy.entity.Ledger;
import com.csy.entity.Products;
import com.csy.mapper.ProductMapper;
import com.csy.service.LedgerService;
import com.csy.service.ProductsService;
import com.csy.service.impl.ProductsServiceImpl;
import com.csy.utils.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/Ledger")
public class LedgerController {
    @Resource
    LedgerService ledgerService;

    @Resource
    ProductMapper productMapper;

    //出库
    public Result shipOut(@Param("id") int id,@Param("specification") String specification,
                          @Param("sid") int sid,@Param("type")int type){
        Result result = ledgerService.shipOut(id, specification, sid, type);

        return result;
    }

    //查询
    public Result queryBy(@Param("optional") String optional, Date date,@Param("offset") int offset, @Param("limit") int limit) {
        List<Products> list = productMapper.findByName(optional);
        List<Integer> ids = list.stream().map(x -> x.getId()).collect(Collectors.toList());
        Result result = ledgerService.queryjilu(ids, date, offset, limit);
        return result;
    }

}
