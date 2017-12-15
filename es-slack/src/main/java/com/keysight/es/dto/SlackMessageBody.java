package com.keysight.es.dto;

import lombok.Data;

@Data
public class SlackMessageBody {

    private String text;


    public SlackMessageBody(String message) {
        this.text=message;
    }
}
