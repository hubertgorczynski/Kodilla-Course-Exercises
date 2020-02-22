package com.kodilla.testing.shape;

public class Square implements Shape {
    private String name = "Square";
    private double edgeLength;

    public Square(double edgeLength) {
        this.edgeLength = edgeLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;

        return Double.compare(square.edgeLength, edgeLength) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(edgeLength);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return Math.pow(edgeLength, 2);
    }

    @Override
    public String toString() {
        return "Shape {" +
                "name='" + name + '\'' +
                ", edgeLength=" + edgeLength +
                '}';
    }
}

