package com.kodilla.good.patterns.food2door;

public abstract class Product {
    private String productName;

    public Product(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Product: " + productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return productName.equals(product.productName);
    }

    @Override
    public int hashCode() {
        return productName.hashCode();
    }
}