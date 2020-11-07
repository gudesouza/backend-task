package com.dekopay.services;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;

abstract public class DatasetHandler {
    public ArrayList mergeDataset(ArrayList list) {
        return null;
    };
    abstract public File readDataset(String path);
}
