package com.kodilla.good.patterns.allegro;

import java.time.LocalDateTime;
import java.util.Random;

public class GameOrderRepository implements ProductOrderRepository {
    @Override
    public boolean createProductOrder(User user, LocalDateTime orderDate, Product product, int quantity) {
        return new Random().nextBoolean();
    }
}