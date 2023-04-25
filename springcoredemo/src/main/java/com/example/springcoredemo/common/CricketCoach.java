package com.example.springcoredemo.common;

import com.example.springcoredemo.common.Coach;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class CricketCoach implements Coach {
    public CricketCoach(){
        System.out.println("Cricket constructor");
    }
    @Override
    public String getDailyWorkOut() {
        return "Practice cricket!!! :)";
    }
}
