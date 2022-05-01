package com.sicilly.demo01;

public class Proxy implements Rent{
    private Landlord landlord;

    public Proxy() {
    }

    public Proxy(Landlord landlord) {
        this.landlord = landlord;
    }

    public void rent() {
        seeHouse();
        landlord.rent();
        sign();
        fare();
    }

    public void seeHouse(){
        System.out.println("中介带你看房");
    }
    public void sign(){
        System.out.println("中介签合同");
    }
    public void fare(){
        System.out.println("收中介费");
    }
}
