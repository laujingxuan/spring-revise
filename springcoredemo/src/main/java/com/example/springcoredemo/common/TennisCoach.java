package com.example.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    public TennisCoach(){
        System.out.println("Tennis constructor");
    }
    @Override
    public String getDailyWorkOut() {
        return "Tennis Coach";
    }
}
