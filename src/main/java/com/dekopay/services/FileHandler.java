package com.dekopay.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

abstract public class FileHandler {
    //abstract method
    abstract public List<String> getFiles(String type);
    abstract public File createFile();
    /*public String getContentType(Path filePath) throws IOException {
        return Files.probeContentType(filePath);
    }*/
    public String getContentType(File file) throws IOException {
        return Files.probeContentType(file.toPath());
    }
}
