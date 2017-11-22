package com.keysight.es.services;

import com.keysight.es.dto.MessageBody;
import com.keysight.es.entities.SlackBotInfoEntity;
import com.keysight.es.repositories.SlackInfoRepository;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Data
public class SlackServiceImpl implements SlackService {

    private final SlackInfoRepository slackInfoRepository;

    @Override
    public String postMessageToSlack(MessageBody messageBody) {

        RestTemplate restTemplate = new RestTemplate();
        if (slackInfoRepository.count() == 0)
            return "no slack bot info configured";

        SlackBotInfoEntity slackBotInfoEntity = slackInfoRepository.findAll().stream().findFirst().get();

        String webhookUrl = slackBotInfoEntity.getWebhookUrl();
        ResponseEntity<String> response
                = restTemplate.postForEntity(webhookUrl, messageBody.getSlackMessageBody(), String.class);

        sendDataToGraphite();
        return response.getBody();
    }

    @Override
    public List<SlackBotInfoEntity> getWebhooksInfo() {
        return slackInfoRepository.findAll();
    }

    @Override
    public void createWebhookInfo(SlackBotInfoEntity slackBotInfoEntity) {

        if (slackInfoRepository.count() == 0) {
            slackInfoRepository.save(slackBotInfoEntity);
        } else {

            SlackBotInfoEntity old = slackInfoRepository.findAll().stream().findFirst().get();
            old.setChannelName(slackBotInfoEntity.getChannelName());
            old.setWebhookUrl(slackBotInfoEntity.getWebhookUrl());
            slackInfoRepository.save(old);
        }
    }

    private void sendDataToGraphite() {
        SimpleGraphiteClient graphiteClient = new SimpleGraphiteClient("localhost", 2003);

// send single value with current timestamp
        graphiteClient.sendMetric("keysight.es.slack", 1);

// send single value with custom timestamp
        //graphiteClient.sendMetric("universal.answer", 42, 1360848777l);

// send multiple values
        /*
        Map<String, Integer> allAnswers = new HashMap<String, Integer>() {{
            put("where.is.my.towel", 42);
            put("where.are.the.dolphins", 42);
        }};
        graphiteClient.sendMetrics(allAnswers);
        */
    }
}
