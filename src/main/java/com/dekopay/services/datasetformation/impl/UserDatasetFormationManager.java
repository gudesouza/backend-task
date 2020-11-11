package com.dekopay.services.datasetformation.impl;

import com.dekopay.services.datasetformation.CsvReader;
import com.dekopay.services.datasetformation.DatasetFormationManager;
import com.dekopay.services.datasetformation.JsonReader;
import com.dekopay.services.datasetformation.XmlReader;

public class UserDatasetFormationManager extends DatasetFormationManager {
    @Override
    public CsvReader getCsvReader() {
        return new UserCsvReader();
    }

    @Override
    public JsonReader getJsonReader() {
        return new UserJsonReader();
    }

    @Override
    public XmlReader getXmlReader() {
        return new UserXmlReader();
    }
}
