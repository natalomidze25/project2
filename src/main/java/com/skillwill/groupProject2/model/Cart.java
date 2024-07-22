package com.skillwill.groupProject2.model;

public class Cart {

    private Product product;

    private Double quantity;

    public Cart(Product product, Double quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Cart(Double quantity) {
        this.quantity = quantity;
    }

    public Cart() {
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
}
