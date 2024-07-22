package com.skillwill.groupProject2.service.cart;

import com.skillwill.groupProject2.model.Cart;
import com.skillwill.groupProject2.model.Product;
import com.skillwill.groupProject2.service.storage.StorageService;
import com.skillwill.groupProject2.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartService {
    private static Map<String,Cart> carts = new HashMap<>();

    @Autowired
    private UserValidator userValidator;


    public void addToCart(String userName,String name, Double quantity){
        userValidator.validateUser(userName);
        Product product = StorageService.getProduct(name);
        if (product == null) {
            throw new RuntimeException("Product not found.");
        }
        if (product.getQuantity() < quantity) {
            throw new RuntimeException( "Insufficient stock.");
        }

        carts.put(name, new Cart(product, quantity + carts.getOrDefault(name,new Cart(0D)).getQuantity()));
        product.setQuantity(product.getQuantity() - quantity);
    }

    public void deleteFromCart(String userName,String name){
        userValidator.validateUser(userName);
        if (!carts.containsKey(name)) {
            throw new RuntimeException( "Insufficient stock.");
        }

        carts.remove(name);
    }

    public static Map<String, Cart> getCarts() {
        return carts;
    }

    public List<Cart> getCartList(String userName){
        userValidator.validateUser(userName);
        return carts.values().stream().toList();
    }

    public void emptyCart(){
        carts = new HashMap<>();
    }

}
