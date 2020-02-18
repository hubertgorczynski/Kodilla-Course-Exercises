package com.kodilla.testing.collection;

import org.junit.*;

import java.util.ArrayList;

public class CollectionTestSuite {

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
    public void testOddNumbersExterminatorEmptyList() {
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        ArrayList<Integer> emptyList = new ArrayList<>();

        ArrayList<Integer> resultList1 = oddNumbersExterminator.exterminate(emptyList);
        System.out.println("Testing empty list");

        Assert.assertEquals(emptyList, resultList1);
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        ArrayList<Integer> normalList = new ArrayList<>();
        normalList.add(1);
        normalList.add(2);
        normalList.add(4);
        normalList.add(8);
        normalList.add(3);
        normalList.add(5);
        normalList.add(12);

        ArrayList<Integer> expectedList = new ArrayList<>();
        expectedList.add(2);
        expectedList.add(4);
        expectedList.add(8);
        expectedList.add(12);

        ArrayList<Integer> resultList2 = oddNumbersExterminator.exterminate(normalList);
        System.out.println("Testing normal list");

        Assert.assertEquals(expectedList, resultList2);
    }
}
