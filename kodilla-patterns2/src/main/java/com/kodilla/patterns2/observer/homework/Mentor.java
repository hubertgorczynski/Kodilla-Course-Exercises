package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {
    private final String mentorName;
    private int updateCount;

    public Mentor(String mentorName) {
        this.mentorName = mentorName;
    }

    @Override
    public void update(Student student) {
        System.out.println("Student " + student.getName() + " from " + student.getCourseName() +
                " course, send new homework to check." + "\n(total number of exercises: " +
                student.getHomeworks().size() + ")");
        updateCount++;
    }

    public String getMentorName() {
        return mentorName;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
