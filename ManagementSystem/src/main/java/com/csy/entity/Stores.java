package com.csy.entity;

import lombok.Data;

import java.util.List;

@Data
public class Stores {
    private int sid;
    //名称
    private String name;
    //位置
    private String location;

    //商品信息
    private List<Products>  productsList;

}
