package com.iudigital.act2ds.example;

import com.iudigital.act2ds.example.Act2DS;

public class MainThread {
    public static void main(String[] args) {
        Act2DS tc = new Act2DS();
        tc.start();
        System.out.println("thread main, procesing");
        System.out.println("finish, main thread");

    }
    
}
