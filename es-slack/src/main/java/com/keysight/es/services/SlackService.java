package com.keysight.es.services;


import com.keysight.es.dto.MessageBody;
import com.keysight.es.entities.SlackBotInfoEntity;

import java.util.List;

public interface SlackService {
    String postMessageToSlack(MessageBody messageBody);

    List<SlackBotInfoEntity> getWebhooksInfo();

    void createWebhookInfo(SlackBotInfoEntity slackBotInfoEntity);
}
