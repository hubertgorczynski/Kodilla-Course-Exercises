package com.kodilla.patterns.factory.tasks;

public final class ShoppingTask implements Task {
    private final String taskName;
    private final String whatToBuy;
    private final double quantity;
    private boolean isExecuted;

    public ShoppingTask(final String taskName, final String whatToBuy, final double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
        isExecuted = false;
    }

    @Override
    public void executeTask() {
        isExecuted = true;
        System.out.println("Task: " + getTaskName() + " has been executed.");
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isExecuted() {
        return isExecuted;
    }

    public String getWhatToBuy() {
        return whatToBuy;
    }

    public double getQuantity() {
        return quantity;
    }
}
