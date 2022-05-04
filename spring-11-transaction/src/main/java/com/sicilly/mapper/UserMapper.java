package com.sicilly.mapper;

import com.sicilly.pojo.User;

import java.util.List;

public interface UserMapper {

    List<User> selectAllUsers();

    // 添加一个用户
    int addUser(User user);
    // 删除一个用户
    int deleteUser(int id);
}