package com.iudigital.act2ds.example;

public class RunnableClass implements Runnable{
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("hello, i am thread" + " " + i);
        }
    } 
}
