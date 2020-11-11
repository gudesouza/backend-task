package com.dekopay.services.datasetformation;

public abstract class DatasetFormationManager {
    public abstract CsvReader getCsvReader();
    public abstract JsonReader getJsonReader();
    public abstract XmlReader getXmlReader();
}
