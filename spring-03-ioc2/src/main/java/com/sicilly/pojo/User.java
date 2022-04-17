package com.sicilly.pojo;

public class User {
    private String name;

    // 有参构造
    public User(String name){
        this.name=name;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println("name="+name);
    }
}
