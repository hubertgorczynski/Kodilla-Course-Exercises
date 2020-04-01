package com.kodilla.good.patterns.allegro;

public class Application {
    public static void main(String[] args) {
        ProductOrderRequestRetriever productOrderRequestRetriever = new ProductOrderRequestRetriever();
        ProductOrderRequest productOrderRequest = productOrderRequestRetriever.retrieve();

        ProductOrderProcessor productOrderProcessor = new ProductOrderProcessor(new MailService(),
                new GameOrderService(), new GameOrderRepository());
        productOrderProcessor.process(productOrderRequest);
    }
}