package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoggerTestSuite {

    @BeforeClass
    public static void writtenToLogs() {
        Logger.getInstance().log("Simple test log");
    }

    @Test
    public void testGetLastLog() {
        //Given
        //When
        String lastLogName = Logger.getInstance().getLastLog();
        //Then
        Assert.assertEquals("Simple test log", lastLogName);
    }
}