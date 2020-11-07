package com.dekopay.services;

import com.dekopay.services.impl.XmlDatasetHandler;

import java.util.ArrayList;
import java.util.Map;

abstract public class DatasetHandler {
    abstract public ArrayList readDataset(String file);
}
