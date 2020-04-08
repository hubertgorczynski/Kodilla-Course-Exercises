package com.kodilla.good.patterns.food2door;

import java.util.List;

public class OrderService {

    public void processAllOrders(List<OrderRequest> orderRequest) {
        orderRequest.stream()
                .map(order -> {
                    System.out.println("\nWe're processing your order now. Thanks for choosing our services "
                            + order.getCustomer().getName());
                    return order.getFoodProducer().process(order.getCustomer(), order.getProductOrderRequest());
                })
                .forEach(status -> System.out.println(" Order success status: " + status));
    }
}