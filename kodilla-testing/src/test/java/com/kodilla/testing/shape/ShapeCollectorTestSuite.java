package com.kodilla.testing.shape;

import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ShapeCollectorTestSuite {
    @Before
    public void before() {
        System.out.println("Test Case: begin");
    }

    @After
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suite: begin");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suite: end");
    }

    @Test
    public void testAddFigure() {

        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shape = new Triangle(3, 4, 5);
        //When
        shapeCollector.addFigure(shape);
        //Then
        assertEquals(1, shapeCollector.getShapeCollection().size());
    }

    @Test
    public void testRemoveFigure() {

        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shape = new Square(4);
        shapeCollector.addFigure(shape);
        //When
        boolean result = shapeCollector.removeFigure(shape);
        //Then
        assertTrue(result);
        assertEquals(0, shapeCollector.getShapeCollection().size());
    }

    @Test
    public void testRemoveNotExistFigure() {

        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shape = new Square(6);
        shapeCollector.addFigure(shape);
        //When
        boolean result = shapeCollector.removeFigure(new Square(2));
        //Then
        assertFalse(result);
        assertEquals(1, shapeCollector.getShapeCollection().size());
    }

    @Test
    public void testGetFigureExistNumber() {

        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shape = new Circle(5);
        shapeCollector.addFigure(shape);
        //When
        Shape shapeResult = shapeCollector.getFigure(0);
        //Then
        assertEquals(shape, shapeResult);
    }

    @Test
    public void testGetFigureNotExistNumber() {

        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        //When
        Shape shapeResult = shapeCollector.getFigure(0);
        //Then
        assertNull(shapeResult);
    }

    @Test
    public void testShowFigures() {

        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(new Square(2));
        shapeCollector.addFigure(new Circle(8));
        shapeCollector.addFigure(new Triangle(3, 4, 5));
        ArrayList<Shape> shapeList = new ArrayList<>();
        shapeList.add(new Square(2));
        shapeList.add(new Circle(8));
        shapeList.add(new Triangle(3, 4, 5));
        //When
        String figures = shapeCollector.showFigures();
        //Then
        assertEquals(shapeList.toString(), figures);
    }
}

