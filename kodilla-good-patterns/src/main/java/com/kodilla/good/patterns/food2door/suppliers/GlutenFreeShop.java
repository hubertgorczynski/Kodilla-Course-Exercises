package com.kodilla.good.patterns.food2door.suppliers;

import com.kodilla.good.patterns.food2door.Customer;
import com.kodilla.good.patterns.food2door.FoodProducer;
import com.kodilla.good.patterns.food2door.products.GlutenFreeProduct;
import com.kodilla.good.patterns.food2door.Product;

import java.util.*;

public class GlutenFreeShop implements FoodProducer {
    private Map<Product, Integer> productsList;

    public GlutenFreeShop() {
        productsList = createProductList();
    }

    private Map<Product, Integer> createProductList() {
        Map<Product, Integer> productsList = new HashMap<>();

        productsList.put(new GlutenFreeProduct("Bread", "Whole grain dark bread"), 28);
        productsList.put(new GlutenFreeProduct("Pasta", "Spiral pasta"), 35);
        productsList.put(new GlutenFreeProduct("Cookies", "Cookies with raisins"), 24);
        productsList.put(new GlutenFreeProduct("Muffins", "Muffins with chocolate"), 50);

        return productsList;
    }

    @Override
    public boolean process(Customer customer, Map<Product, Integer> productsOrders) {
        return isProductsAvailable(productsOrders);
    }

    private boolean isProductsAvailable(Map<Product, Integer> productsOrders) {
        for (Map.Entry<Product, Integer> entry : productsOrders.entrySet()) {
            Optional<Integer> productQty = Optional.ofNullable(productsList.get(entry.getKey()));
            if (productQty.orElse(0) < entry.getValue()) {
                System.out.println("Gluten Free Shop: We're sorry. Product is unavailable.");
                return false;
            }
        }
        return true;
    }
}