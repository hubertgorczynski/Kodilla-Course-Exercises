package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {
    private final int idNumber;
    private String name;
    private char sex;
    private LocalDate birthDate;
    private int postsNumber;

    public ForumUser(int idNumber, String name, char sex, LocalDate birthDate, int postsNumber) {
        this.idNumber = idNumber;
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
        this.postsNumber = postsNumber;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public String getName() {
        return name;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPostsNumber() {
        return postsNumber;
    }

    @Override
    public String toString() {
        return "ForumUser {" +
                "ID Number = " + idNumber +
                ", name = " + name +
                ", sex = " + sex +
                ", birthDate = " + birthDate +
                ", postsNumber = " + postsNumber +
                '}';
    }
}