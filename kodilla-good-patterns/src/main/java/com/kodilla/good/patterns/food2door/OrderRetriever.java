package com.kodilla.good.patterns.food2door;

import com.kodilla.good.patterns.food2door.products.GlutenFreeProduct;
import com.kodilla.good.patterns.food2door.products.MeatProduct;
import com.kodilla.good.patterns.food2door.products.GrainProduct;
import com.kodilla.good.patterns.food2door.suppliers.ExtraFoodShop;
import com.kodilla.good.patterns.food2door.suppliers.GlutenFreeShop;
import com.kodilla.good.patterns.food2door.suppliers.HealthyShop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRetriever {

    public List<OrderRequest> retrieve() {
        List<OrderRequest> orderRequestList = new ArrayList<>();

        Customer customer1 = new Customer("Joe Swanson");
        FoodProducer foodProducer1 = new GlutenFreeShop();
        Map<Product, Integer> productsList1 = new HashMap<>();
        productsList1.put(new GlutenFreeProduct("Bread", "Whole grain dark bread"), 2);
        productsList1.put(new GlutenFreeProduct("Pasta", "Spiral pasta"), 5);
        productsList1.put(new GlutenFreeProduct("Cookies", "Cookies with raisins"), 4);
        productsList1.put(new GlutenFreeProduct("Muffins", "Muffins with chocolate"), 5);
        orderRequestList.add(new OrderRequest(customer1, foodProducer1, productsList1));

        Customer customer2 = new Customer("Peter Griffin");
        FoodProducer foodProducer2 = new ExtraFoodShop();
        Map<Product, Integer> productsList2 = new HashMap<>();
        productsList2.put(new MeatProduct("Grilled sausage", "pork"), 4);
        productsList2.put(new MeatProduct("Chicken burger", "chicken"), 2);
        productsList2.put(new GrainProduct("Cereals", false), 2);
        orderRequestList.add(new OrderRequest(customer2, foodProducer2, productsList2));

        Customer customer3 = new Customer("Glenn Quagmire");
        FoodProducer foodProducer3 = new HealthyShop();
        Map<Product, Integer> productsList3 = new HashMap<>();
        productsList3.put(new GlutenFreeProduct("Apple dream", "100% of apple juice"), 10);
        productsList3.put(new GlutenFreeProduct("Cherry shake", "Gluten free but not taste free"), 5);
        productsList3.put(new GrainProduct("Spaghetti noodles", true), 5);
        orderRequestList.add(new OrderRequest(customer3, foodProducer3, productsList3));

        return orderRequestList;
    }
}