package com.dekopay.services.impl;

import com.dekopay.constants.FileConstants;
import com.dekopay.services.FileHandler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserFileHandler extends FileHandler {

    /**
     * Get all userFiles from the dir
     * @return
     */
    @Override
    public List<String> getFiles() {
        // all files user files
        try (Stream<Path> walk = Files.walk(Paths.get(FileConstants.USER_DIR + FileConstants.INPUT_FILE_DIR))) {
            List<String> fileList = walk.map(x -> x.toString())
                    .filter(f -> f.contains("users")).collect(Collectors.toList());

            return fileList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public File createFile() {
        return null;
    }
}
