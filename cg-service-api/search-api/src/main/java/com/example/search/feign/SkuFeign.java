package com.example.search.feign;

import com.example.cgcommon.constant.Result;
import com.goods.pojo.Sku;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//@FeignClient(name="search")
//@RequestMapping("/search")
@FeignClient(name="goods")
@RequestMapping("/sku")
public interface SkuFeign {

    /**
     * 搜索
     * @param searchMap
     * @return
     */
    @GetMapping
    Map search(@RequestParam(required = false) Map searchMap);

    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable int page, @PathVariable  int size);

    /***
     * 根据ID查询Sku数据
     * @param id
     * @return
     */
    @GetMapping(value="/{id}")
    public Result<Sku> findById(@PathVariable Long id);


}
