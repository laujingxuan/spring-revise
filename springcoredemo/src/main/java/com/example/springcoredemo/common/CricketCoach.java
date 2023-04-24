package com.example.springcoredemo.common;

import com.example.springcoredemo.common.Coach;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkOut() {
        return "Practice cricket!!! :)";
    }
}
