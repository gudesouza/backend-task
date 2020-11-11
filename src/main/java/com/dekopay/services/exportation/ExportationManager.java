package com.dekopay.services.exportation;

public abstract class ExportationManager {
    public abstract CsvExporter getCsvExporter();
    public abstract JsonExporter getJsonExporter();
    public abstract XmlExporter getXmlExporter();
}
