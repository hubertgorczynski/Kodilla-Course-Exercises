package com.kodilla.good.patterns.food2door.suppliers;

import com.kodilla.good.patterns.food2door.*;
import com.kodilla.good.patterns.food2door.products.GlutenFreeProduct;
import com.kodilla.good.patterns.food2door.products.GrainProduct;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class HealthyShop implements FoodProducer {
    private Map<Product, Integer> productsList;

    public HealthyShop() {
        productsList = createProductList();
    }

    private Map<Product, Integer> createProductList() {

        Map<Product, Integer> productsList = new HashMap<>();

        productsList.put(new GlutenFreeProduct("Apple dream", "100% of apple juice"), 20);
        productsList.put(new GlutenFreeProduct("Cherry shake", "Gluten free but not taste free"), 25);
        productsList.put(new GrainProduct("White bread", false), 20);
        productsList.put(new GrainProduct("Spaghetti noodles", true), 15);

        return productsList;
    }

    @Override
    public boolean process(Customer customer, Map<Product, Integer> productsOrders) {
        return (productsOrders.size() >= 2 && isProductsAvailable(productsOrders));
    }

    private boolean isProductsAvailable(Map<Product, Integer> productsOrders) {
        for (Map.Entry<Product, Integer> entry : productsOrders.entrySet()) {
            Optional<Integer> productQty = Optional.ofNullable(productsList.get(entry.getKey()));
            if (productQty.orElse(0) < entry.getValue()) {
                System.out.println("Healthy Shop: We're sorry. Product is unavailable.");
                return false;
            }
        }
        return true;
    }
}