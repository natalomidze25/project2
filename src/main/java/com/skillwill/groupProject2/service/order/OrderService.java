package com.skillwill.groupProject2.service.order;

import com.skillwill.groupProject2.dto.OrderDto;
import com.skillwill.groupProject2.dto.OrderRequest;
import com.skillwill.groupProject2.model.Order;
import com.skillwill.groupProject2.model.Product;
import com.skillwill.groupProject2.service.cart.CartService;
import com.skillwill.groupProject2.service.storage.StorageService;
import com.skillwill.groupProject2.validator.OrderValidator;
import com.skillwill.groupProject2.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderValidator orderValidator;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private CartService cartService;
    static List<Order> orders = new ArrayList<>();
    static Double userDeposit = 1000D;

    public List<OrderDto> getUserOrders(String username){
        userValidator.validateUser(username);
         return orders.stream().map(OrderDto::new).collect(Collectors.toList());
    }

    public void buy(String username,String productName, Double quantity){
        userValidator.validateUser(username);
        orderValidator.validateProduct(productName);

        Product product = StorageService.getProduct(productName);

        orderValidator.validateQuantity(product.getQuantity(), quantity);
        orderValidator.validateDeposit(userDeposit, quantity, product.getPrice());

        orders.add(new Order(product, quantity));
        userDeposit = userDeposit - product.getPrice() * quantity;
    }

    public void checkoutCart(String username){
        userValidator.validateUser(username);
        cartService.getCartList(username).forEach(c->{
            buy(username,c.getProduct().getName(),c.getQuantity());
        });
        cartService.emptyCart();
    }

}
