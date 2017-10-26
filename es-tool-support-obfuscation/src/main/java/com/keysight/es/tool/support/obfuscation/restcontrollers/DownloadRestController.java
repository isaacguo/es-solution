package com.keysight.es.tool.support.obfuscation.restcontrollers;

import com.keysight.es.tool.support.obfuscation.entities.DotfuscatorInfo;
import com.keysight.es.tool.support.obfuscation.repositories.DotfuscatorInfoRepository;
import com.keysight.es.tool.support.obfuscation.services.DownloadService;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.sql.DataSourceDefinition;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/downloads")
@Data
public class DownloadRestController {

    private final DownloadService downloadService;

    @GetMapping
    public List<String> getDotfuscatorList() {
        return downloadService.getList();
    }

    @GetMapping(value = "/file/{filename}/")
    public void getNodeManager(HttpServletRequest request, HttpServletResponse response, @PathVariable("filename") String filename) throws IOException {

        downloadService.getDotfuscator(request, response, filename);
    }

    @GetMapping(value = "/latest")
    public String getDotfuscatorLatest() {
        return downloadService.getLatest();
    }

    @GetMapping(value = "/latest/download")
    public void downloadDotfuscatorLatest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        downloadService.downloadLatest(request, response);
    }

    @GetMapping(value = "/licenseFile")
    public void getLicenseFile(HttpServletRequest request, HttpServletResponse response) throws IOException {

        downloadService.getLicenseFile(request, response);
    }
}
