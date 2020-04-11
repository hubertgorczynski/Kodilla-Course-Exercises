package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)

@SpringBootTest
public class CalculatorTestSuite {
    @Test
    public void testCalculations() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);

        //When
        double addResult = calculator.add(4, 9);
        double subResult = calculator.sub(17, 5);
        double mulResult = calculator.mul(5, 2);
        double divResult = calculator.div(4, 2);

        //Then
        Assert.assertEquals(13, addResult, 0.001);
        Assert.assertEquals(12, subResult, 0.001);
        Assert.assertEquals(10, mulResult, 0.001);
        Assert.assertEquals(2, divResult, 0.001);
    }
}