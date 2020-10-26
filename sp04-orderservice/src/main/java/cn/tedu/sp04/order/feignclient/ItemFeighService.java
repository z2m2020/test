package cn.tedu.sp04.order.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import cn.tedu.sp01.pojo.Item;
import cn.tedu.web.util.JsonResult;

@FeignClient(name="item-service",fallback=ItemFeignServiceFB.class)
public interface ItemFeighService {
	@GetMapping("/{orderId}")
	JsonResult<List<Item>> getItem(@PathVariable String orderId);
	
	@PostMapping("/decreasNumber")
	JsonResult decreaseNumber(@RequestBody List<Item> Items);
}
