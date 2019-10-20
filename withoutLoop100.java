package com.company;

public class withoutLoop100 {
    public void loop(int n) {
        if(n < 1) {
            return;
        }
        loop(n - 1);
        System.out.print(n);

    }
    public static void main(String[] args) {
        withoutLoop100 w = new withoutLoop100();
        w.loop(100);
    }
}
