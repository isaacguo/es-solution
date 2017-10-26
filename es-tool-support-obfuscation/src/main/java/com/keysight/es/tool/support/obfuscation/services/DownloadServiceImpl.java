package com.keysight.es.tool.support.obfuscation.services;

import com.keysight.es.tool.support.obfuscation.StorageProperties;
import com.keysight.es.tool.support.obfuscation.entities.DotfuscatorInfo;
import com.keysight.es.tool.support.obfuscation.repositories.DotfuscatorInfoRepository;
import lombok.Data;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class DownloadServiceImpl implements DownloadService {

    private final DotfuscatorInfoRepository dotfuscatorInfoRepository;
    private final StorageProperties storageProperties;


    public List<String> getList() {
        return fileList(storageProperties.getDotfuscatorDirectory());
    }

    private List<String> fileList(String directory) {
        List<String> fileNames = new ArrayList<>();
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directory))) {
            for (Path path : directoryStream) {
                fileNames.add(path.getFileName().toString());
            }
        } catch (IOException ex) {
        }
        return fileNames;
    }

    @Override
    public void getDotfuscator(HttpServletRequest request, HttpServletResponse response, String filename) throws IOException {

        // get your file as InputStream
        ServletContext context = request.getServletContext();

        String url = this.storageProperties.getDotfuscatorDirectory() + File.separatorChar + filename;
        InputStream is = new FileInputStream(url);
        String mimeType = context.getMimeType(url);
        response.setContentType(mimeType);
        response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
        IOUtils.copy(is, response.getOutputStream());
        is.close();
        response.flushBuffer();
    }
}
