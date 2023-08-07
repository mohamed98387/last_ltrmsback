package org.sid.secservice.service;

import org.sid.secservice.entities.AuthMail;
import org.sid.secservice.entities.Mail;

public interface EmailService {
    public void sendCodeByMail(Mail mail);
    public void sendAuthByMail(AuthMail authMail);
}
