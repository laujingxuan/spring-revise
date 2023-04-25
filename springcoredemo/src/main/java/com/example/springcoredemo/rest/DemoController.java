package com.example.springcoredemo.rest;

import com.example.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
    private Coach anotherCoach;

    //constructor injection
//    @Autowired
//    public DemoController(@Qualifier("baseballCoach") Coach theCoach){
//        myCoach = theCoach;
//    }

    @Autowired
    public DemoController(@Qualifier("swimCoach") Coach theCoach, @Qualifier("swimCoach")Coach theAnotherCoach){
        myCoach = theCoach;
        anotherCoach = theAnotherCoach;
    }

//    //setter injection
//    @Autowired
//    public void setCoach(Coach theCoach){
//        myCoach = theCoach;
//    }

    @GetMapping("/check")
    public String check(){
        return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkOut();
    }
}
