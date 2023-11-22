package org.sid.secservice.service;

import org.sid.secservice.entities.AuthMail;
import org.sid.secservice.entities.Mail;

import java.io.InputStream;

public interface EmailService {
    public void sendCodeByMail(Mail mail);
    public void sendAuthByMail(AuthMail authMail);
    public void sendfileByMail(AuthMail authMail, InputStream excelFile, String fileName);
    public void sendfileByMailPlan(AuthMail authMail, InputStream excelFile, String fileName);
}
