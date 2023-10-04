package org.example.models;

import lombok.Data;

@Data
public class EmailReqDTO {

    // Class data members
    private String recipient;
    private String msgBody;
    private String subject;
    private String attachment;
}
