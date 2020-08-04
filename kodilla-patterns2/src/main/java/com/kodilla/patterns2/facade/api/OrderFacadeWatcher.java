package com.kodilla.patterns2.facade.api;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Aspect
@Component
public class OrderFacadeWatcher {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderFacadeWatcher.class);

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))" +
            "&& args(orderDto, userId) && target(object)")
    public void logEvent(OrderDto orderDto, Long userId, Object object) {
        LOGGER.info("Logging the event: processOrder method call:" +
                "\nClass: " + object.getClass().getName() +
                "\nArgs/OrderDto: " + orderDto.getItems().stream()
                .map(ItemDto::toString)
                .collect(Collectors.joining(",\n")) +
                "\nUserId: " + userId);
    }
}
