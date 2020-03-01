package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage() {
        //Given
        int[] numbers = {3, 4, 5, 2, 9, 7, 4, 7, 9, 1, 5, 8, 4, 5, 7, 3, 7, 9, 3, 6};
        //When
        double average = ArrayOperations.getAverage(numbers);
        //Then
        Assert.assertEquals(5.4, average, 0.0001);
    }
}