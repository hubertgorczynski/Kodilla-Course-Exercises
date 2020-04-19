package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {
    public static final String DRIVINGTASK = "DRIVINGTASK";
    public static final String PAINTINGTASK = "PAINTINGTASK";
    public static final String SHOPPINGTASK = "SHOPPINGTASK";

    public final Task makeTask(final String taskClass) {
        switch (taskClass) {
            case DRIVINGTASK:
                return new DrivingTask("Delivery", "house", "car");
            case PAINTINGTASK:
                return new PaintingTask("Painting project", "green", "fence");
            case SHOPPINGTASK:
                return new ShoppingTask("Shopping list", "sweet roll", 3);
            default:
                return null;
        }
    }
}