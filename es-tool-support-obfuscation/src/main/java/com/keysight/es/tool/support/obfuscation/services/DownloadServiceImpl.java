package com.keysight.es.tool.support.obfuscation.services;

import com.keysight.es.tool.support.obfuscation.StorageProperties;
import com.keysight.es.tool.support.obfuscation.entities.DotfuscatorInfo;
import com.keysight.es.tool.support.obfuscation.repositories.DotfuscatorInfoRepository;
import lombok.Data;
import org.apache.commons.io.FilenameUtils;
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
                if (!bareFileName(path).endsWith("-latest")) {
                    fileNames.add(path.getFileName().toString());
                }
            }
        } catch (IOException ex) {
        }
        return fileNames;
    }

    private String bareFileName(Path filename) {
        return FilenameUtils.removeExtension(filename.getFileName().toString());
    }

    private void getFile(HttpServletRequest request, HttpServletResponse response, String fullFileName, String filename) throws IOException {
        // get your file as InputStream
        ServletContext context = request.getServletContext();

        InputStream is = new FileInputStream(fullFileName);
        String mimeType = context.getMimeType(fullFileName);
        response.setContentType(mimeType);
        response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
        IOUtils.copy(is, response.getOutputStream());
        is.close();
        response.flushBuffer();
    }

    @Override
    public void getDotfuscator(HttpServletRequest request, HttpServletResponse response, String filename) throws IOException {
        String url = this.storageProperties.getDotfuscatorDirectory() + File.separatorChar + filename;
        this.getFile(request, response, url, filename);
    }

    @Override
    public void getLicenseFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String url = this.storageProperties.getDotfuscatorLicensePath();
        this.getFile(request, response, url, "license.dat");
    }

    @Override
    public String getLatest() {
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(storageProperties.getDotfuscatorDirectory()))) {
            for (Path path : directoryStream) {
                if (bareFileName(path).endsWith("-latest")) {
                    return path.getFileName().toString().replace("-latest", "");
                }
            }
        } catch (IOException ex) {
        }
        return "";
    }

    @Override
    public void downloadLatest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(storageProperties.getDotfuscatorDirectory()))) {
            for (Path path : directoryStream) {
                if (bareFileName(path).endsWith("-latest")) {
                    String url = this.storageProperties.getDotfuscatorDirectory() + File.separatorChar + path.getFileName().toString();
                    this.getFile(request, response, url, path.getFileName().toString());
                }
            }
        } catch (IOException ex) {
        }
    }
}
