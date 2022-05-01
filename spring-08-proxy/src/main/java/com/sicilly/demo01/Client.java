package com.sicilly.demo01;

public class Client {
    public static void main(String[] args) {
//      房东要出租房子
        Landlord landlord=new Landlord();
//      代理，中介帮房东出租。但是代理一般有一些附属操作
        Proxy proxy = new Proxy(landlord);
//      客户直接找中介租房
        proxy.rent();
    }
}
