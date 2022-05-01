package com.sicilly.demo3;

import com.sicilly.demo01.Proxy;

public class Client {
    public static void main(String[] args) {
        // 真实角色
        Landlord landlord=new Landlord();
        // 代理角色：现在没有
        ProxyInvocationHandler pih=new ProxyInvocationHandler(); // 调用程序处理角色
        // 通过调用程序处理角色来处理我们要调用的接口对象
        pih.setRent(landlord);  // 设置要代理的角色
        Rent proxy = (Rent)pih.getProxy(); // 获得代理类 这里的proxy就是动态生成的
        proxy.rent(); // 通过代理来出租房子
    }
}
