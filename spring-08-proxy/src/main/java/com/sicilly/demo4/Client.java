package com.sicilly.demo4;

import com.sicilly.demo02.UserService;
import com.sicilly.demo02.UserServiceImpl;

public class Client {
    public static void main(String[] args) {
        // 真实角色
        UserServiceImpl userService = new UserServiceImpl();
        // 代理角色：现在没有
        ProxyInvocationHandler pih=new ProxyInvocationHandler(); // new一个调用程序处理角色
        // 通过调用程序处理角色来处理我们要调用的接口对象
        pih.setTarget(userService);  // 设置要代理的真实角色
        UserService proxy = (UserService)pih.getProxy(); // 动态生成代理类
        proxy.add(); // 通过代理来调用方法
    }
}
