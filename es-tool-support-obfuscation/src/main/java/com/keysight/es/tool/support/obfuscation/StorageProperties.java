package com.keysight.es.tool.support.obfuscation;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.nio.file.Path;

@Component
@RefreshScope
@Data
public class StorageProperties {

    @Value("${dotfuscator.directory}")
    private String dotfuscatorDirectory;
    @Value("${dotfuscator.license.path}")
    private String dotfuscatorLicensePath;

    @Value("${dotfuscator.license.name}")
    private String dotfuscatorLicenseName;

}
