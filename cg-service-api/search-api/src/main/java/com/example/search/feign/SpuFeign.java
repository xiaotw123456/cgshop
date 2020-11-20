package com.example.search.feign;

import com.example.cgcommon.constant.Result;
import com.goods.pojo.Spu;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value="goods")//服务名称
@RequestMapping("/spu")
public interface SpuFeign {

    @GetMapping(value = "/search" )
    public Result findPage(@RequestBody(required = false) Spu spu, @PathVariable int page, @PathVariable int size);

    /**
     * 商品详情获取数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Spu> findById(@PathVariable(name = "id") Long id);
}
