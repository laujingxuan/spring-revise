package com.example.springcoredemo.common;

import org.springframework.context.annotation.Primary;

public class SwimCoach implements Coach{

    public SwimCoach(){
        System.out.println("Swimming cons");
    }

    @Override
    public String getDailyWorkOut() {
        return "Swimming";
    }
}
