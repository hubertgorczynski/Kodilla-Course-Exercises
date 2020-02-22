package com.kodilla.testing.shape;

public class Circle implements Shape {
    private String name = "Circle";
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circle circle = (Circle) o;

        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(radius);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return "Shape {" +
                "name='" + name + '\'' +
                ", radius=" + radius +
                '}';
    }
}
