package com.keysight.es.repositories;

import com.keysight.es.entities.SlackBotInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SlackInfoRepository extends JpaRepository<SlackBotInfoEntity, Long> {

}
