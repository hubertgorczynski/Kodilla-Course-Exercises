package com.kodilla.testing.shape;

public class Triangle implements Shape {
    private String name = "Triangle";
    private double edgeLengthA;
    private double edgeLengthB;
    private double edgeLengthC;

    public Triangle(double edgeLengthA, double edgeLengthB, double edgeLengthC) {
        this.edgeLengthA = edgeLengthA;
        this.edgeLengthB = edgeLengthB;
        this.edgeLengthC = edgeLengthC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (Double.compare(triangle.edgeLengthA, edgeLengthA) != 0) return false;
        if (Double.compare(triangle.edgeLengthB, edgeLengthB) != 0) return false;
        return Double.compare(triangle.edgeLengthC, edgeLengthC) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(edgeLengthA);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(edgeLengthB);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(edgeLengthC);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    private boolean checkTriangleCondition() {
        return (edgeLengthA + edgeLengthB > edgeLengthC) &&
                (edgeLengthA + edgeLengthC > edgeLengthB) &&
                (edgeLengthB + edgeLengthC > edgeLengthA);
    }

    private double getHalfOfCircuit() {
        return (edgeLengthA + edgeLengthB + edgeLengthC) / 2;
    }

    private double heronsPattern(double halfOfCircuit) {
        return Math.sqrt(halfOfCircuit * (halfOfCircuit - edgeLengthA) * (halfOfCircuit - edgeLengthB) * (halfOfCircuit - edgeLengthC));
    }

    @Override
    public double getField() {
        if (checkTriangleCondition()) {
            double halfOfCircuit = getHalfOfCircuit();
            return heronsPattern(halfOfCircuit);
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Shape {" +
                "name='" + name + '\'' +
                ", edgeLengthA=" + edgeLengthA +
                ", edgeLengthB=" + edgeLengthB +
                ", edgeLengthC=" + edgeLengthC +
                '}';
    }
}
