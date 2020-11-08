package com.dekopay.services;


import com.dekopay.entities.user.User;
import com.dekopay.services.impl.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class ImportManagerTest {
    @Test
    public void testUserData() throws IOException {
        //instantiate userImportManager
        UserImportManager userImportManager = new UserImportManager();

        //start importing process
        Collection importedUsers = userImportManager.importData();
        System.out.println("Test Starts here.....");

        //start exporting in Csv
        CsvExportManager csvExportManager = new CsvExportManager();
        csvExportManager.exportData(importedUsers);

        //start exporting in Json
        JsonExportManager jsonExportManager = new JsonExportManager();
        jsonExportManager.exportData(importedUsers);

        //start exporting in Xml
        XmlExportManager xmlExportManager = new XmlExportManager();
        xmlExportManager.exportData(importedUsers);


    }
    /*public void mergeDatasets (ArrayList datasets) {
        ArrayList mergedDataset = new ArrayList();
        for (Object dataset : datasets) {

        }
    }*/
}
