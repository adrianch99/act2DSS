package com.iudigital.act2ds.example;


public class AnonymousClass {
    public static void main(String[] args) {
        Thread hilo = new Thread(new Runnable(){
            
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("hello, i am thread");
                  
                }
            }
        });
        hilo.start();
        System.out.println("hello, i am main thread and success");
        System.out.println("finish");
    }
}


