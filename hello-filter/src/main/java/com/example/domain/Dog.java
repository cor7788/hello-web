package com.example.domain;

public class Dog implements Animal {
    @Override
    public String eat() {
        System.out.println("the dog begin to eat...");
        return "吃完了";
    }
}
