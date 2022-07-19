package com.it_academy.database.driver.tables;

public class User {
    private int userId;
    private String name;
    private String address;

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userid=" + userId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
