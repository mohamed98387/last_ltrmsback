package org.sid.secservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.sid.secservice.util.Code;

@Data
@AllArgsConstructor
public class Mail {


    private String to;
    private String code;
}
