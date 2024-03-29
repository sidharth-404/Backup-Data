package com.myshop.cart.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.myshop.cart.dto.CartDetails;
import com.myshop.cart.model.CartItem;
import com.myshop.cart.service.CartService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/cart")
public class CartController {
	RestTemplate restClient=new RestTemplate();
	@Autowired
	private CartService cartService;

	@GetMapping("/message")
	public String greet()
	{
		return "cart";
	}
//	@GetMapping("/product")
//	public String fetchProductGreetMessage()
//	{
//		String msg=restClient.getForObject("http://localhost:8100/product",String.class);
//		return "message reached from service"+msg;
//		
//	}
	
	

	@GetMapping("/items")
	public CartDetails getCartDetails() {
		List<CartItem> items = cartService.getAllItems();
		float totalCartVlue = cartService.calculateTotalCost();
		CartDetails cartDetails = new CartDetails();
		cartDetails.setItemsList(items);
		cartDetails.setTotalCartValue(totalCartVlue);
		return cartDetails;
		
	}
	
	@PostMapping("/items/product/{productId}")
	@CircuitBreaker(fallbackMethod = "addNewItemFallback", name = "cb-product")
	public List<CartItem> addNewItem(@PathVariable String productId){
		return cartService.addToCart(productId);
	}
	public List<CartItem> addNewItemFallback(@PathVariable String productId, Throwable t){
		System.err.println(t.getMessage());
		return new ArrayList<CartItem>();
	}

	
	@DeleteMapping("/items/product/{productId}")
	public List<CartItem> deleteItem(@PathVariable String productId){
		return cartService.removeFromCart(productId);
	}


}