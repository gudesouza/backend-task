package com.dekopay.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Responsible to handle the files, in this case we only have a Default implementation (DefaultFileHandler)
 * its current responsibilities are to get files of an entity type and get the MINE tyoe of a file
 */
abstract public class FileHandler {
    /**
     * Abstratct method and responsible to get files of a data entity type (in this case we're using users),
     * but this can be also used by other entity types
     * @param type
     * @return
     */
    abstract public List<String> getFiles(String type);

    /**
     * Responsible to get the MIME Type of a file so this can be used to determine which of the
     * current three types csv, json or xml.
     * @param file
     * @return
     * @throws IOException
     */
    public String getContentType(File file) throws IOException {
        return Files.probeContentType(file.toPath());
    }
}
