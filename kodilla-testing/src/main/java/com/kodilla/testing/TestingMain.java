package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        int addResult = calculator.add(5, 5);
        int subtractResult = calculator.subtract(5, 5);

        if (addResult == 10) {
            System.out.println("Add method test OK");
        } else {
            System.out.println("Add method test Error!");
        }

        if (subtractResult == 0) {
            System.out.println("Subtract method test OK");
        } else {
            System.out.println("Subtract method test Error!");
        }
    }
}