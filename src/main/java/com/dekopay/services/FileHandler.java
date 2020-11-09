package com.dekopay.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Responsible to handle the files
 */
abstract public class FileHandler {
    /**
     * Abstratct method and responsible to get files of a datatype
     * @param type
     * @return
     */
    abstract public List<String> getFiles(String type);

    /**
     * Responsible to get the MIME Type of a file
     * @param file
     * @return
     * @throws IOException
     */
    public String getContentType(File file) throws IOException {
        return Files.probeContentType(file.toPath());
    }
}
