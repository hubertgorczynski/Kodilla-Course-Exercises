package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {

    private ArrayList<Shape> shapeCollection = new ArrayList<>();

    public ArrayList<Shape> getShapeCollection() {
        return shapeCollection;
    }

    public void addFigure(Shape shape) {
        shapeCollection.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        return shapeCollection.remove(shape);
    }

    public Shape getFigure(int n) {
        if (n < shapeCollection.size() && n >= 0) {
            return shapeCollection.get(n);
        } else {
            return null;
        }
    }

    public String showFigures(){
        return shapeCollection.toString();
    }
}
