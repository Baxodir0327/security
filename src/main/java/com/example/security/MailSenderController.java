package com.example.security;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("api/mail")
@RequiredArgsConstructor
public class MailSenderController {
    private final MailSenderService mailSenderService;

    @PostMapping("/simple-mail")
    public String sendMail(@RequestParam String username) throws MessagingException, IOException {
        mailSenderService.sendSimpleMail(username);
        return "Ok";
    }
    @PostMapping("/attachment-mail")
    public String senAttachment(@RequestParam String username) throws MessagingException, IOException {
        mailSenderService.sendAttachmentMail(username);
        return "Ok";
    }

    @PostMapping("/image-mail")
    public String sendImageMail(@RequestParam String username) {
        mailSenderService.sendImageMail(username);
        return "Message Sent !!!";
    }

    @PostMapping("/freemarker-mail")
    public String sendFreeMarkerMail(@RequestParam String username) {
        mailSenderService.sendFreeMarkerMail(username);
        return "Message Sent !!!";
    }
}
