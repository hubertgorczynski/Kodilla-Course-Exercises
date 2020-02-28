package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int idNumber;
    private final String name;
    private final char sex;
    private final LocalDate birthDate;
    private final int postsNumber;

    public ForumUser(final int idNumber, final String name, final char sex, final LocalDate birthDate, final int postsNumber) {
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