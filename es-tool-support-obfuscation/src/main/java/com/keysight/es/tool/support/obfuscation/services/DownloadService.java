package com.keysight.es.tool.support.obfuscation.services;

import com.keysight.es.tool.support.obfuscation.entities.DotfuscatorInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface DownloadService {

    List<String> getList();

    void getDotfuscator(HttpServletRequest request, HttpServletResponse response, String filename) throws IOException;


}
