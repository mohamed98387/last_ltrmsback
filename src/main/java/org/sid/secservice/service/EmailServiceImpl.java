package org.sid.secservice.service;

import org.sid.secservice.entities.AuthMail;
import org.sid.secservice.entities.Mail;
import org.sid.secservice.util.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{
    private JavaMailSender javaMailSender;
    private Code code ;
@Autowired
    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    @Async
    public void sendCodeByMail(Mail mail) {
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setFrom("mohamedlajmi198@gmail.com");
        simpleMailMessage.setTo(mail.getTo());
        simpleMailMessage.setSubject("code Active");
        simpleMailMessage.setText(mail.getCode());
        javaMailSender.send(simpleMailMessage);
        System.out.println("mail sent seccess");
    }
    @Override
    @Async
    public void sendAuthByMail(AuthMail authMail) {
        String emailContent = "Hello this your username authentication :" + authMail.getUsername() + "," +
                "\n\nTo add your password click to this link: " +
                authMail.getLink() +
                "\n\nBest regards.";
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setFrom("mohamedlajmi198@gmail.com");
        simpleMailMessage.setTo(authMail.getTo());
        simpleMailMessage.setSubject("You Authentification");
        simpleMailMessage.setText(emailContent);
        javaMailSender.send(simpleMailMessage);
        System.out.println(authMail.getUsername());
        System.out.println("mail sent seccess");
    }
}
