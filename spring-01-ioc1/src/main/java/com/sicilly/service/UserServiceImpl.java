package com.sicilly.service;

import com.sicilly.dao.UserDao;
import com.sicilly.dao.UserDaoImpl;
import com.sicilly.dao.UserDaoMysqlImpl;
import com.sicilly.dao.UserDaoOracleImpl;

public class UserServiceImpl implements UserService{

//     原本：程序控制对象 new不同的dao实现类
//     private UserDao userDao=new UserDaoImpl();
//     private UserDao userDao=new UserDaoMysqlImpl();
//    private UserDao userDao=new UserDaoOracleImpl();


//     现在：利用set进行动态实现值的注入
     private UserDao userDao;
     public void setUserDao(UserDao userDao){
       this.userDao=userDao;
     }

    //业务层调DAO层
    public void getUser() {
        userDao.getUser();
    }
}
