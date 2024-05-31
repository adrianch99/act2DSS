package com.iudigital.act2ds.example;

public class Act2DS extends Thread{

    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("hello, i am thread");
        }
        
    }
}
