package com.twu.biblioteca.entity;

public class Item {
    private String name;
    private String checkOutUser;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCheckOutUser() {
        return checkOutUser;
    }

    public void setCheckOutUser(String checkOutUser) {
        this.checkOutUser = checkOutUser;
    }
}
