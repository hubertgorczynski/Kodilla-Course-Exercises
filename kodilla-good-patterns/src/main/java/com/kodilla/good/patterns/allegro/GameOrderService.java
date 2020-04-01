package com.kodilla.good.patterns.allegro;

import java.time.LocalDateTime;
import java.util.Random;

public class GameOrderService implements ProductOrderService {
    @Override
    public boolean sold(User user, LocalDateTime orderDate, Product product, int quantity) {
        return new Random().nextBoolean();
    }
}