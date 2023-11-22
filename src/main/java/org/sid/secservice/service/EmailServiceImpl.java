package org.sid.secservice.service;

import org.apache.poi.util.IOUtils;
import org.sid.secservice.entities.AuthMail;
import org.sid.secservice.entities.Mail;
import org.sid.secservice.util.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.InputStream;

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

    @Override
    @Async
    public void sendfileByMail(AuthMail authMail, InputStream excelFile, String fileName) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("mohamedlajmi198@gmail.com");
            helper.setTo(authMail.getTo());
            helper.setSubject("Your Authentication");
            helper.setText("Hello, this is your username authentication: " + authMail.getUsername() + "\n\nBest regards.");

            // Add the Excel file as an attachment
            helper.addAttachment(fileName, new ByteArrayResource(IOUtils.toByteArray(excelFile)));

            javaMailSender.send(message);

            System.out.println(authMail.getUsername());
            System.out.println("Mail sent successfully");
        } catch (Exception e) {
            // Handle exceptions, e.g., MailException or IOException
            e.printStackTrace();
            // You may want to log the exception or throw a custom exception
        }
    }
    @Override
    @Async
    public void sendfileByMailPlan(AuthMail authMail, InputStream excelFile, String fileName) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("mohamedlajmi198@gmail.com");
            helper.setTo(authMail.getTo());
            helper.setSubject("Planification de tansport");
            helper.setText("Hello, this is your Planification this week: " + "\n\nBest regards.");

            // Add the Excel file as an attachment
            helper.addAttachment(fileName, new ByteArrayResource(IOUtils.toByteArray(excelFile)));

            javaMailSender.send(message);

            System.out.println(authMail.getUsername());
            System.out.println("Mail sent successfully");
        } catch (Exception e) {
            // Handle exceptions, e.g., MailException or IOException
            e.printStackTrace();
            // You may want to log the exception or throw a custom exception
        }
    }
}
