package com.kodilla.good.patterns.allegro;

abstract class Product {
    private String productName;
    private String productDescription;
    private double productPrice;

    public Product(String productName, String productDescription, double productPrice) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return  "Product name: '" + productName + '\'' + "\n  Description: " + productDescription +
                "\n  Price: " + productPrice;
    }
}