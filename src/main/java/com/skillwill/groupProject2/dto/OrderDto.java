package com.skillwill.groupProject2.dto;

import com.skillwill.groupProject2.model.Order;

import java.time.LocalDateTime;

public class OrderDto {
    private String productName;

    private Double quantity;

    private LocalDateTime orderTime;

    public OrderDto(Order order) {
        this.productName = order.getProduct().getName();
        this.quantity = order.getQuantity();
        this.orderTime = order.getOrderTime();
    }

    public String getProductName() {
        return productName;
    }

    public Double getQuantity() {
        return quantity;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }
}
