package com.kodilla.good.patterns.food2door.suppliers;

import com.kodilla.good.patterns.food2door.Customer;
import com.kodilla.good.patterns.food2door.FoodProducer;
import com.kodilla.good.patterns.food2door.products.GrainProduct;
import com.kodilla.good.patterns.food2door.products.MeatProduct;
import com.kodilla.good.patterns.food2door.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ExtraFoodShop implements FoodProducer {
    private Map<Product, Integer> productsList;

    public ExtraFoodShop() {
        productsList = createProductList();
    }

    private Map<Product, Integer> createProductList() {
        Map<Product, Integer> productsList = new HashMap<>();

        productsList.put(new MeatProduct("Grilled sausage", "Pork"), 3);
        productsList.put(new MeatProduct("Chicken burger", "Chicken"), 24);
        productsList.put(new GrainProduct("Cereals", false), 2);
        productsList.put(new GrainProduct("Crackers", false), 14);

        return productsList;
    }

    public boolean process(Customer customer, Map<Product, Integer> productsOrders) {
        for (Map.Entry<Product, Integer> entry : productsOrders.entrySet()) {
            Optional<Integer> productQty = Optional.ofNullable(productsList.get(entry.getKey()));
            if (productQty.orElse(0) < entry.getValue()) {
                System.out.println("Extra Food Shop: We're sorry. Product is unavailable.");
                return false;
            }
        }
        return true;
    }
}