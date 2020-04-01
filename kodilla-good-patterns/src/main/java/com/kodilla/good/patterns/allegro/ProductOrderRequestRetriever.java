package com.kodilla.good.patterns.allegro;

import java.time.LocalDateTime;

public class ProductOrderRequestRetriever {

    public ProductOrderRequest retrieve() {
        User user = new User("Wild_Johny565", "Johny", "Cage");
        LocalDateTime orderDate = LocalDateTime.of(2020, 2, 11, 13, 18);
        Product product = new Game("The Witcher 3: Wild Hunt","Role-playing game", 89.99);
        int quantity = 1;

        System.out.println("\nRetrieve product request");
        System.out.println("User: " + user.getNickName() + "\nDate: " + orderDate +
                "\n" + product + "\n  Quantity: " + quantity);
        return new ProductOrderRequest(user, orderDate, product, quantity);
    }
}