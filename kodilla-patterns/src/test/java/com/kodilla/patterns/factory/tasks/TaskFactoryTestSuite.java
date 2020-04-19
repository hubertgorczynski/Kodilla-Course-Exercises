package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    @Test
    public void testFactoryDrivingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task drivingTask = factory.makeTask(TaskFactory.DRIVINGTASK);
        boolean beforeExecution = drivingTask.isExecuted();
        drivingTask.executeTask();
        //Then
        Assert.assertEquals("Delivery", drivingTask.getTaskName());
        Assert.assertFalse(beforeExecution);
        Assert.assertTrue(drivingTask.isExecuted());
    }

    @Test
    public void testFactoryShoppingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shoppingTask = factory.makeTask(TaskFactory.SHOPPINGTASK);
        boolean beforeExecution = shoppingTask.isExecuted();
        shoppingTask.executeTask();
        //Then
        Assert.assertEquals("Shopping list", shoppingTask.getTaskName());
        Assert.assertFalse(beforeExecution);
        Assert.assertTrue(shoppingTask.isExecuted());
    }

    @Test
    public void testFactoryPaintingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task paintingTask = factory.makeTask(TaskFactory.PAINTINGTASK);
        boolean beforeExecution = paintingTask.isExecuted();
        paintingTask.executeTask();
        //Then
        Assert.assertEquals("Painting project", paintingTask.getTaskName());
        Assert.assertFalse(beforeExecution);
        Assert.assertTrue(paintingTask.isExecuted());
    }

    @Test
    public void testNullTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task nullTask = factory.makeTask("differentTask");
        //Then
        Assert.assertNull(nullTask);
    }
}