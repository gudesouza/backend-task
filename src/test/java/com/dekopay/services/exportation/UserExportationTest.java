package com.dekopay.services.exportation;

import com.dekopay.constants.FileConstants;
import com.dekopay.services.exportation.impl.decorator.CsvFileUserDecorator;
import com.dekopay.services.exportation.impl.decorator.CsvWriter;
import com.dekopay.services.impl.UserImportManager;
import org.junit.jupiter.api.Test;
import com.dekopay.services.exportation.impl.UserExportationManager;

import java.util.Collection;

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

    @Test
    public void testExporter() {
        FileHelper csvWriter = new CsvWriter();
        FileHelper csvUserFile = new CsvFileUserDecorator(csvWriter);
        System.out.println("testExporter" + csvUserFile.getClass());

    }
}
