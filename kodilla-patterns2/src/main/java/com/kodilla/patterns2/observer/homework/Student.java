package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class Student implements Observable {
    private final String name;
    private final List<Observer> observers;
    private final List<String> homeworks;
    private final KodillaCourses courseName;

    public Student(String name, KodillaCourses courseName) {
        this.name = name;
        observers = new ArrayList<>();
        homeworks = new ArrayList<>();
        this.courseName = courseName;
    }

    public void addHomework(String exercise) {
        homeworks.add(exercise);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public String getName() {
        return name;
    }

    public List<String> getHomeworks() {
        return homeworks;
    }

    public KodillaCourses getCourseName() {
        return courseName;
    }
}
