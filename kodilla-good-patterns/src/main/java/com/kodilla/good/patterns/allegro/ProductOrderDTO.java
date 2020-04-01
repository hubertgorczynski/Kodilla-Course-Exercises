package com.kodilla.good.patterns.allegro;

import java.time.LocalDateTime;

public class ProductOrderDTO {
    private User user;
    private LocalDateTime orderDate;
    private Product product;
    private int quantity;
    private boolean isSuccessfullySold;

    public ProductOrderDTO(final User user, final LocalDateTime orderDate, final Product product, final int quantity,
                           final boolean isSuccessfullySold) {
        this.user = user;
        this.orderDate = orderDate;
        this.product = product;
        this.quantity = quantity;
        this.isSuccessfullySold = isSuccessfullySold;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isSuccessfullySold() {
        return isSuccessfullySold;
    }
}