package com.keysight.es.tool.support.obfuscation.services;

import com.keysight.es.tool.support.obfuscation.entities.DotfuscatorInfo;
import com.keysight.es.tool.support.obfuscation.repositories.DotfuscatorInfoRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class DownloadServiceImpl implements DownloadService {

    private final DotfuscatorInfoRepository dotfuscatorInfoRepository;

    public List<DotfuscatorInfo> getList() {
        return dotfuscatorInfoRepository.findAll();
    }
}
