package com.keysight.es.tool.support.obfuscation.restcontrollers;

import com.keysight.es.tool.support.obfuscation.entities.DotfuscatorInfo;
import com.keysight.es.tool.support.obfuscation.repositories.DotfuscatorInfoRepository;
import com.keysight.es.tool.support.obfuscation.services.DownloadService;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.sql.DataSourceDefinition;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/downloads")
@Data
public class DownloadRestController {

    private final DownloadService downloadService;

    @GetMapping
    public List<DotfuscatorInfo> getDotfuscatorList()
    {
        return downloadService.getList();
    }

}
