package com.keysight.es.tool.support.obfuscation;

import com.keysight.es.tool.support.obfuscation.entities.DotfuscatorInfo;
import com.keysight.es.tool.support.obfuscation.repositories.DotfuscatorInfoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Runner {

    @Bean
    CommandLineRunner commandLineRunner(DotfuscatorInfoRepository dotfuscatorInfoRepository)
    {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {

                DotfuscatorInfo dotfuscatorInfo=new DotfuscatorInfo();
                dotfuscatorInfo.setVersion("4.31.1_2.0");

                dotfuscatorInfoRepository.save(dotfuscatorInfo);

            }
        };
    }
}
