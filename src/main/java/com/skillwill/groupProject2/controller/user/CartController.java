package com.skillwill.groupProject2.controller.user;


import com.skillwill.groupProject2.model.Cart;
import com.skillwill.groupProject2.service.cart.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.skillwill.groupProject2.model.Product;
import com.skillwill.groupProject2.service.storage.StorageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cart")
public class CartController {


    @Autowired
    private CartService cartService;
    
    @GetMapping("/view_products")
    public Map<String, Product> viewProducts() {
        return StorageService.getAllProduct().values().stream().collect(Collectors.toMap(Product::getName, product -> product));
    }


    @PostMapping("/add_to_cart")
    public ResponseEntity<?> addToCart(@RequestParam String username,
                                       @RequestParam("name") String name,
                                       @RequestParam("quantity") Double quantity) {
        cartService.addToCart(username,name,quantity);
        return new ResponseEntity<>("Product added to cart successfully.",HttpStatus.OK);
    }

    @DeleteMapping("delete_cart")
    public ResponseEntity<?> deleteFromCart(@RequestParam("name") String name,
                                            @RequestParam String username){
        cartService.deleteFromCart(username,name);
        return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
    }


    @GetMapping("/view_cart")
    public List<Cart> viewCart(@RequestParam String username) {
        return cartService.getCartList(username);
    }

}




