package org.sid.secservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthMail {
    private String to;
    private String username;
    private String link;
}
