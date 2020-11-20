package search.controller;

import com.example.cgcommon.constant.Result;
import com.example.search.feign.SkuFeign;
import com.example.search.feign.SpuFeign;
import com.goods.pojo.Sku;
import com.goods.pojo.Spu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @version: V1.0
 * @author: Administrator
 * @className: SkuController
 * @packageName: com.cgou.search.controller
 * @description: 这是用户类
 * @data: 2020/11/2 13:17
 **/

@Controller
@RequestMapping(value = "/search")
public class SkuController {

    @Autowired
    private SkuFeign skuFeign;

    @Autowired
    private SpuFeign spuFeign;

    /**
     * 搜索
     * @param searchMap
     * @return
     */
    @GetMapping(value = "/list")
    public String search(@RequestParam(required = false) Map searchMap, Model model){
        //调用changgou-service-search微服务
       // Map resultMap = skuFeign.search(searchMap);
        Result result=skuFeign.findPage(0,10);
        System.out.println("------返回数据:"+result);
      //  model.addAttribute("result",resultMap);
        System.out.println("======"+result.getData());
        model.addAttribute("result", result.getData());
        return "search";
    }

    @GetMapping(value="/goodsDetail")
    public String goodsDetail( Model model,long id){

        Result result=skuFeign.findById(id);
        Sku sku= (Sku) result.getData();
        Result spuResult= spuFeign.findById(sku.getSpuId());
        System.out.println("------商品详情页获取数据:"+result);
        model.addAttribute("sku", result.getData());
        model.addAttribute("spu", spuResult.getData());
        return "item";
    }
}
