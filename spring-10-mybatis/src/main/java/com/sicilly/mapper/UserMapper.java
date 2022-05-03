package com.sicilly.mapper;

import com.sicilly.pojo.User;

import java.util.List;

public interface UserMapper {

    List<User> selectAllUsers();
}