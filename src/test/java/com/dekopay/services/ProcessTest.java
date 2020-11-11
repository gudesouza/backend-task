package com.dekopay.services;


import com.dekopay.entities.user.User;
import com.dekopay.services.exportation.impl.UserExportationManager;
import com.dekopay.services.impl.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class ProcessTest {
    @Test
    public void testUserProcess() throws IOException {
        //instantiate userImportManager
        UserImportManager userImportManager = new UserImportManager();

        //start importing process
        Collection importedUsers = userImportManager.importData();
        System.out.println("Process Test Started.....");

        //instantiate an Abstract Factory for user exportation
        UserExportationManager userExportationManager = new UserExportationManager();
        //start exporting in Csv
        userExportationManager.getCsvExporter().export(importedUsers);
        //start exporting in Json
        userExportationManager.getJsonExporter().export(importedUsers);
        //start exporting in Xml
        userExportationManager.getJsonExporter().export(importedUsers);

    }
}
