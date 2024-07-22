package com.skillwill.groupProject2.controller.user;

import com.skillwill.groupProject2.dto.OrderDto;
import com.skillwill.groupProject2.dto.OrderRequest;
import com.skillwill.groupProject2.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("")
    public ResponseEntity<List<OrderDto>> getUserOrders(@RequestParam String username) {

        return new ResponseEntity<>(orderService.getUserOrders(username), HttpStatus.OK);
    }

    @PostMapping("buy")
    public ResponseEntity<String> buy(@RequestParam String username, @RequestBody OrderRequest request) {
        orderService.buy(username, request.getProductName(), request.getQuantity());
        return new ResponseEntity<>("product ordered", HttpStatus.OK);
    }

    @PostMapping("checkout")
    public ResponseEntity<String> checkoutCart(@RequestParam String username) {
        orderService.checkoutCart(username);
        return new ResponseEntity<>("product ordered", HttpStatus.OK);
    }

}
