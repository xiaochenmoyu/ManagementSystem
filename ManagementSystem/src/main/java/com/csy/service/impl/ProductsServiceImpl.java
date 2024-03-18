package com.csy.service.impl;

import com.csy.entity.Products;
import com.csy.mapper.ProductMapper;
import com.csy.service.ProductsService;
import com.csy.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Resource
    ProductMapper productMapper;

    @Override
    public Result selectAll() {
        return null;
    }

    @Override
    public Result findAllProducts(int page, int size, String optional) {
        Result<Object> result = new Result<>();

        int offset = (page - 1) * size;
        List<Products> allProducts = productMapper.findAllProducts(optional, offset, size);
        int count = productMapper.CountSelectAll();
        int total = count / size;
        result.setTotal(total);
        result.setData(allProducts);
        result.setPage(page);
        result.setSize(size);
        return result;
    }

    @Override
    public Result updateProducts(Products products) {
        Result result = new Result<>();
        int i = productMapper.updateProducts(products);
        if (i>0){
            result.setCode(200);
            result.setMsg("修改成功");
        }else {
            result.setCode(400);
            result.setMsg("修改失败");
        }
        return result;
    }

    @Override
    public Result deleteProduct(int id) {
        Result result = new Result<>();
        int i = productMapper.deleteProduct(id);
        if (i>0){
            result.setCode(200);
            result.setMsg("删除成功");
        }else {
            result.setCode(400);
            result.setMsg("删除失败");
        }
        return result;
    }

    @Override
    public Result insertProduct(Products products) {
        Result result = new Result<>();
        int i = productMapper.insertProduct(products);
        if (i>0){
            result.setCode(200);
            result.setMsg("舔加成功");
        }else {
            result.setCode(400);
            result.setMsg("添加失败");
        }
        return result;
    }

    @Override
    public List<Products> findByName(String optional) {
        return productMapper.findByName(optional);
    }
}
