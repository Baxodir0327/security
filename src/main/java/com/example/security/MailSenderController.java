package com.example.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;

@RestController
@RequestMapping("/api/mail")
@Slf4j
public class MailSenderController {

    @PostMapping("/simple-mail")
    public String sendSimpleMail(@RequestParam String username) {
//        for (int i = 0; i < 1000; i++) {
            log.info("Simple Mail Sent username : {}| Time : {}", username, new Date());
//        }
        return "Message Sent !!!";
    }

    @PostMapping("/html-mail")
    public String sendHtmlMail(@RequestParam String username) {
        if (new Random().nextBoolean()) {
            throw new RuntimeException("Error For New Custom Appender");
        } else {
            log.info("HTML Mail Sent username : {}", username);
        }
        return "Message Sent !!!";
    }

    @PostMapping("/attachment-mail")
    public String sendAttachmentMail(@RequestParam String username) {
        return "Message Sent !!!";
    }

    @PostMapping("/image-mail")
    public String sendImageMail(@RequestParam String username) {
        return "Message Sent !!!";
    }

    @PostMapping("/freemarker-mail")
    public String sendFreeMarkerMail(@RequestParam String username) {

        return "Message Sent !!!";
    }

}
