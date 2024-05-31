package com.iudigital.act2ds.example;

import com.iudigital.act2ds.example.RunnableClass;

public class PrincipalRunnable {
    public static void main(String[] args) {
        RunnableClass runnableClass = new RunnableClass();
        Thread hilo = new Thread(runnableClass);
        hilo.start();
        System.out.println("hello, i am principal main thread");
        System.out.println("finish");
    }
}
