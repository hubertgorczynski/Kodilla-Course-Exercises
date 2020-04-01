package com.kodilla.good.patterns.allegro;

public class User {
    private String nickName;
    private String userName;
    private String userSurname;

    public User(String nickName, String userName, String userSurname) {
        this.nickName = nickName;
        this.userName = userName;
        this.userSurname = userSurname;
    }

    public String getNickName() {
        return nickName;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserSurname() {
        return userSurname;
    }
}