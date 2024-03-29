package com.myshop.order.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myshop.order.model.Order;
import com.myshop.order.service.OrderService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
//	
//	@GetMapping
//	public String greet() {
//		return "Message from Order Service";
//	}
	@GetMapping
	public List<Order> getAllOrders(){
		return orderService.getAllOrders();
	}

	
	@PostMapping
	public Order placeOrder(@RequestBody Order order) {
		return orderService.placeOrder(order.getOrderItems());
	}
	
	@GetMapping("/{orderId}")
	public Order getOrderDetails(@PathVariable String orderId) {
		return orderService.getOrderDetails(orderId);
	}


}