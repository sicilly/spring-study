package com.sicilly.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

public class User {
    private String name;

    public String getName() {
        return name;
    }

    @Value("hii")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
