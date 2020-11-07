package com.dekopay.services;

import java.io.File;
import java.util.List;

abstract public class FileHandler {
    //abstract method
    abstract public List<String> getFiles();
    abstract public File createFile();
}
