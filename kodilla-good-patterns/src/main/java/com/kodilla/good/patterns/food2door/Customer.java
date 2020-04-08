package com.kodilla.good.patterns.food2door;

public class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        return getName().equals(customer.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}