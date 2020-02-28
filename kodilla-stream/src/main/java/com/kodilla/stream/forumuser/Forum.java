package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> forumUserList = new ArrayList<>();

    public Forum() {
        forumUserList.add(new ForumUser(1, "Jim", 'M', LocalDate.of(2003, 3, 15), 18));
        forumUserList.add(new ForumUser(2, "Julian", 'M', LocalDate.of(2005, 8, 2), 0));
        forumUserList.add(new ForumUser(3, "Cory", 'M', LocalDate.of(1998, 4, 18), 9));
        forumUserList.add(new ForumUser(4, "Sarah", 'F', LocalDate.of(1960, 11, 25), 6));
        forumUserList.add(new ForumUser(5, "Lara", 'F', LocalDate.of(1984, 8, 19), 7));
        forumUserList.add(new ForumUser(6, "Jack", 'M', LocalDate.of(2006, 3, 17), 0));
        forumUserList.add(new ForumUser(7, "Barbra", 'F', LocalDate.of(1998, 8, 23), 0));
        forumUserList.add(new ForumUser(8, "Rick", 'M', LocalDate.of(1990, 9, 23), 3));
        forumUserList.add(new ForumUser(9, "Sonia", 'F', LocalDate.of(1980, 10, 15), 2));
        forumUserList.add(new ForumUser(10, "Suzy", 'F', LocalDate.of(1994, 6, 8), 0));
    }

    public List<ForumUser> getForumUserList() {
        return new ArrayList<>(forumUserList);
    }
}