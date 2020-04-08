package com.kodilla.good.patterns.food2door.products;

import com.kodilla.good.patterns.food2door.Product;

public class GrainProduct extends Product {
    private boolean isGMOModified;

    public GrainProduct(String productName, boolean isGMOModified) {
        super(productName);
        this.isGMOModified = isGMOModified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        GrainProduct that = (GrainProduct) o;

        return isGMOModified == that.isGMOModified;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (isGMOModified ? 1 : 0);
        return result;
    }
}