package cn.tedu.sp04.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.sp01.pojo.Item;
import cn.tedu.sp01.pojo.Order;
import cn.tedu.sp01.pojo.User;
import cn.tedu.sp01.service.OrderService;
import cn.tedu.sp04.order.feignclient.ItemFeighService;
import cn.tedu.sp04.order.feignclient.UserFeignService;
import cn.tedu.web.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ItemFeighService itemService;

    @Autowired
    private UserFeignService userService;

    @Override
    public Order getOrder(String orderId) {
        //TODO: 调用商品服务,获取订单中的商品列表
        JsonResult<User> user=userService.getUser(7);
        //TODO: 调用用户服务,获取用户信息
        JsonResult<List<Item>> items=itemService.getItem(orderId);

        Order order = new Order();
        order.setId(orderId);
        order.setUser(user.getData());
        order.setItems(items.getData());
        return order;

    }

    @Override
    public void addOrder(Order order) {

        itemService.decreaseNumber(order.getItems());

        userService.addScore(7, 100);
        log.info("保存订单: "+order);
    }

}
