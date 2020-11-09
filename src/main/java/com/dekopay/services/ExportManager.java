package com.dekopay.services;

import org.w3c.dom.Document;

import java.io.IOException;
import java.util.Collection;

public interface ExportManager {
    /**
     * Responsible to export data of a collection
     * @param collection
     * @throws IOException
     */
    void exportData(Collection collection) throws IOException;

}
