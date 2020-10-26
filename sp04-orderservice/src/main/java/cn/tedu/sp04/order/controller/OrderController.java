package cn.tedu.sp04.order.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.sp01.pojo.Item;
import cn.tedu.sp01.pojo.Order;
import cn.tedu.sp01.pojo.User;
import cn.tedu.sp01.service.OrderService;
import cn.tedu.web.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/{orderId}")
    public JsonResult<Order> getOrder(@PathVariable String orderId){
        log.info("get order ,id= "+orderId);

        Order order =orderService.getOrder(orderId);
        return JsonResult.ok(order);
    }

    @GetMapping("/")
    public JsonResult addOrder() {
        Order order=new Order();
        order.setId("123abc");
        order.setUser(new User(7,null,null));
        order.setItems(Arrays.asList(new Item[] {
                new Item(1,"aaa",11),
                new Item(2,"bbb",22),
                new Item(3,"ccc",33),
                new Item(4,"ddd",44),
                new Item(5,"eee",55),
        }));
        orderService.addOrder(order);
        return JsonResult.ok();
    }
}
