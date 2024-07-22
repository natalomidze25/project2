package com.skillwill.groupProject2.model;

import java.time.LocalDateTime;

public class Order {

    private Product product;

    private Double quantity;

    private LocalDateTime orderTime;

    public Order() {
    }

    public Order(Product product, Double quantity) {
        this.product = product;
        this.quantity = quantity;
        this.orderTime = LocalDateTime.now();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }
}
