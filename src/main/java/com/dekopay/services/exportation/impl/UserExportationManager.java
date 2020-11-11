package com.dekopay.services.exportation.impl;

import com.dekopay.services.exportation.ExportationManager;
import com.dekopay.services.exportation.CsvExporter;
import com.dekopay.services.exportation.JsonExporter;
import com.dekopay.services.exportation.XmlExporter;

public class UserExportationManager extends ExportationManager {

    @Override
    public CsvExporter getCsvExporter() {
        return new UserCsvExporter();
    }

    @Override
    public JsonExporter getJsonExporter() {
        return new UserJsonExporter();
    }

    @Override
    public XmlExporter getXmlExporter() {
        return new UserXmlExporter();
    }
}
