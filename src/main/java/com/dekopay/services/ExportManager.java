package com.dekopay.services;

import org.w3c.dom.Document;

import java.io.IOException;
import java.util.Collection;

/**
 * The ExportManager is responsible to mainly export a collection of entries, the implementation of this class
 * are responsible to export the different types of files, CsvExportManager implementation is responsible to export CSV files,
 * the JsonExportManager implementation is responsible to export JSON files, the XmlExportManager implementation is responsible
 * to export XML files, etc... we can add more
 */
public interface ExportManager {
    /**
     * Responsible to export data of a collection
     * @param collection
     * @throws IOException
     */
    void exportData(Collection collection) throws IOException;

}
