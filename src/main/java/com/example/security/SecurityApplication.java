package com.example.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

@SpringBootApplication
@EnableScheduling
public class SecurityApplication {

    public static void main(String[] args) {
        /*Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            private SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
            @Override
            public void run() {
                System.out.print("\r"+"Time is "+sdf.format(new Date()));
            }
        };

        timer.scheduleAtFixedRate(task, 4, 1);*/

        SpringApplication.run(SecurityApplication.class, args);
    }

}
