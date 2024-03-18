package com.csy.mapper;

import com.csy.entity.Products;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {
    //
    List<Products> selectProductsAll();
    //
    int CountSelectAll();
    //
    List<Products> findAllProducts(@Param("optional") String optional, @Param("offset") int offset, @Param("limit") int limit);
    //
    int updateProducts(Products products);

    int deleteProduct(int id);
    //
    int insertProduct(Products products);

    List<Products> findByName(@Param("optional") String optional);
}
