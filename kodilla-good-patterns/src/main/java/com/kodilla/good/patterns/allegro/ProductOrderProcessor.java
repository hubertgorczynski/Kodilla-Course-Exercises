package com.kodilla.good.patterns.allegro;

public class ProductOrderProcessor {
    private CustomerService customerService;
    private ProductOrderService productOrderService;
    private ProductOrderRepository productOrderRepository;

    public ProductOrderProcessor(CustomerService customerService, ProductOrderService productOrderService,
                                 ProductOrderRepository productOrderRepository) {
        this.customerService = customerService;
        this.productOrderService = productOrderService;
        this.productOrderRepository = productOrderRepository;
    }

    public ProductOrderDTO process(ProductOrderRequest productOrderRequest) {
        boolean isSuccessfullySold = productOrderService.sold(productOrderRequest.getUser(),
                productOrderRequest.getOrderDate(),
                productOrderRequest.getProduct(),
                productOrderRequest.getQuantity());
        if (isSuccessfullySold) {
            customerService.inform(productOrderRequest.getUser());
            productOrderRepository.createProductOrder(productOrderRequest.getUser(),
                    productOrderRequest.getOrderDate(),
                    productOrderRequest.getProduct(),
                    productOrderRequest.getQuantity());
        } else {
            System.out.println("\nWe're sorry but Your order request has been rejected. Please try again later.");
        }

        return new ProductOrderDTO(productOrderRequest.getUser(),
                productOrderRequest.getOrderDate(),
                productOrderRequest.getProduct(),
                productOrderRequest.getQuantity(),
                isSuccessfullySold);
    }
}