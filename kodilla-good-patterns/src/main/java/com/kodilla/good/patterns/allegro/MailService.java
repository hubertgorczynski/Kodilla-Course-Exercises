package com.kodilla.good.patterns.allegro;

public class MailService implements CustomerService {

    @Override
    public void inform(User user) {
        System.out.println("\nThank You " + user.getNickName() + " for choosing our store. We are processing Your order.");
    }
}