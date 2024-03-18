package com.csy.entity;

import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

@Data
public class Ledger {
    //编号
    private int id;
    //产品编号
    private int product_id;
    //门店编号
    private int store_id;
    //数量
    private int quantity;
    //类型0-入库，1-出库
    private int type;
    //时间戳
    private Timestamp timestamp;

}
