package cn.tedu.sp04.order.feignclient;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import cn.tedu.sp01.pojo.Item;
import cn.tedu.web.util.JsonResult;
@Component
public class ItemFeignServiceFB implements ItemFeighService {

    @Override
    public JsonResult<List<Item>> getItem(String orderId) {
        if(Math.random()<0.5) {
            return JsonResult.ok().data(

                    Arrays.asList(new Item[] {
                            new Item(1,"缓存aaa",2),
                            new Item(2,"缓存aaa",1),
                            new Item(3,"缓存aaa",3),
                            new Item(4,"缓存aaa",1),
                            new Item(5,"缓存aaa",5),
                    })

            );
        }
        return JsonResult.err("无法获取订单商品列表");
    }

    @Override
    public JsonResult decreaseNumber(List<Item> Items) {
        return JsonResult.err("无法修改商品库存");
    }

}
