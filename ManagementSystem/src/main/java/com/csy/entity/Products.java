package com.csy.entity;

import lombok.Data;

@Data
public class Products {
    private int id;
    //名称
    private String optional;
    // 数量
    private int specification;
    // 单价
    private double price;
    //0 删除；1 存在
    private int del=1;
}
