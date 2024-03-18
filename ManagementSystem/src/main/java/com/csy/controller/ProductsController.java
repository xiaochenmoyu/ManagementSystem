package com.csy.controller;

import com.csy.entity.Products;
import com.csy.mapper.ProductMapper;
import com.csy.service.ProductsService;
import com.csy.utils.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/api/products")
public class ProductsController {

    @Resource
    ProductsService productsService;

    @GetMapping(value = "/findAllProducts")
    @ResponseBody
    public Result findAllProducts(@Param("optional") String optional, @Param("offset") int offset, @Param("limit") int limit){
        return   productsService.findAllProducts(offset, limit, optional);
    }

    @PostMapping(value = "/updateProducts")
    @ResponseBody
    public Result updateProducts(@RequestBody Products products){
        Result result = productsService.updateProducts(products);
        return result;
    }

    @GetMapping(value = "/deleteProduct")
    @ResponseBody
    public Result deleteProduct(@Param("id") int id){
        Result result = productsService.deleteProduct(id);
        return result;
    }
}
