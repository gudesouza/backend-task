package com.dekopay.services.exportation;

import org.junit.jupiter.api.Test;
import com.dekopay.services.exportation.impl.UserExportationManager;

public class UserExportationTest {

    @Test
    public void testUserJsonExporter() {
        UserExportationManager factory = new UserExportationManager();
        //factory.getJsonExporter().export();
    }

    @Test
    public void testUserCsvExporter() {
        UserExportationManager factory = new UserExportationManager();
        //factory.getCsvExporter().export();
    }

    @Test
    public void testUserXmlExporter() {
        UserExportationManager factory = new UserExportationManager();
        //factory.getXmlExporter().export();
    }
}
