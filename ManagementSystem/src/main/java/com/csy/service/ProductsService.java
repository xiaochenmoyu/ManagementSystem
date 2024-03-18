package com.csy.service;

import com.csy.entity.Products;
import com.csy.utils.Result;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductsService {
    public Result selectAll();

    // 分页查询商品
    public Result findAllProducts(int page, int size, String optional);

    Result updateProducts(Products products);

    Result deleteProduct(int id);
    //
    Result insertProduct(Products products);
    //
    List<Products> findByName(String optional);
}
