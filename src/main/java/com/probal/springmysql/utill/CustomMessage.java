package com.probal.springmysql.utill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class CustomMessage {

    private String messageId;
    private Object messageBody;
    private Date messageDate;

    public CustomMessage(Object messageBody) {
        this.messageBody = messageBody;
    }
}
