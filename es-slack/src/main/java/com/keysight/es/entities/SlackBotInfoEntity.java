package com.keysight.es.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class SlackBotInfoEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String uuid;

    String channelName;
    String webhookUrl;

}
