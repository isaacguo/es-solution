package com.keysight.es.restcontrollers;


import com.keysight.es.dto.MessageBody;
import com.keysight.es.dto.WebhookInfo;
import com.keysight.es.entities.SlackBotInfoEntity;
import com.keysight.es.services.SlackService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
@Data
public class SlackRestController {

    private final SlackService slackService;

    @GetMapping
    public List<SlackBotInfoEntity> getWebhooksInfo()
    {
       return slackService.getWebhooksInfo();
    }

    @PostMapping("/create")
    public void createWebhookInfo(@RequestBody SlackBotInfoEntity slackBotInfoEntity)
    {
        this.slackService.createWebhookInfo(slackBotInfoEntity);
    }

    @PostMapping
    public String postMessageToSlack(@RequestBody MessageBody messageBody)
    {
        return slackService.postMessageToSlack(messageBody);
    }
}

