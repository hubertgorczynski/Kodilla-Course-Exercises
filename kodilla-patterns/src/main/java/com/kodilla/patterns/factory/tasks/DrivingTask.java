package com.kodilla.patterns.factory.tasks;

public final class DrivingTask implements Task {
    private final String taskName;
    private final String where;
    private final String using;
    private boolean isExecuted;

    public DrivingTask(final String taskName, final String where, final String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
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

    public String getWhere() {
        return where;
    }

    public String getUsing() {
        return using;
    }
}
