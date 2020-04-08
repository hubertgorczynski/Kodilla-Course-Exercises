package com.kodilla.good.patterns.food2door.products;

import com.kodilla.good.patterns.food2door.Product;

public class MeatProduct extends Product {
    private String typeOfMeat;

    public MeatProduct(String productName, String typeOfMeat) {
        super(productName);
        this.typeOfMeat = typeOfMeat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MeatProduct)) return false;
        if (!super.equals(o)) return false;

        MeatProduct that = (MeatProduct) o;

        return typeOfMeat.equals(that.typeOfMeat);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + typeOfMeat.hashCode();
        return result;
    }
}