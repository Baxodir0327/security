package com.example.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Configuration
public class ScheduledTasks {
    //Delay har ish tugagandan song1 sec ishlaydi
//    @Scheduled(initialDelay = 4, fixedDelay = 1, timeUnit = TimeUnit.SECONDS)
    public void fixedDelayTest() {
        System.out.println("(Fixed Delay) Time is: " + System.currentTimeMillis());
    }

    //Rate har 1 sec ishlaydi
//    @Scheduled(initialDelay = 4, fixedRate = 1, timeUnit = TimeUnit.SECONDS)
    public void fixedRateTest() {
        System.out.println("(Fixed Rate) Time is: " + System.currentTimeMillis());
    }

    @Scheduled(cron = "0 0 20 L * 1",zone = "Asia/Tashkent")//"10-20/3 * * * * *" "0 0 8 * * 1"
    public void croneTest1() {
        System.out.println("(Crone Evry Second) Time is: " + new Date());
    }
}
