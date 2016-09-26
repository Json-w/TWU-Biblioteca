package com.twu.biblioteca.entity;

public class User {
    private String username;
    private String password;
    private String email;
    private String phone;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        email = email == null ? "" : email;
        phone = phone == null ? "" : phone;
        return
                "username='" + username + '\'' +
                        ", email='" + email + '\'' +
                        ", phone='" + phone + '\'';
    }
}
