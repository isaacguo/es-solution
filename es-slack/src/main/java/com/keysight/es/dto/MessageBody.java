package com.keysight.es.dto;

import lombok.Data;

@Data
public class MessageBody {

    private String token;
    private String message;

    public SlackMessageBody getSlackMessageBody()
    {
        return new SlackMessageBody(message);
    }

}
