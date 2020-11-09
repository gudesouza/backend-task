package com.dekopay.services;

import com.dekopay.constants.FileConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class ExportManagerTest {

    @Test
    public void testCsvExport() {
        File f = new File(FileConstants.USER_DIR + "/data/in/users.csv");
        Assertions.assertEquals(true, f.exists());
        System.out.println("Exported /data/in/users.csv exists");
    }

    @Test
    public void testJsonExport() {
        File f = new File(FileConstants.USER_DIR + "/data/in/users.json");
        Assertions.assertEquals(true, f.exists());
        System.out.println("Export /data/in/users.json exists");
    }

    @Test
    public void testXmlExport() {
        File f = new File(FileConstants.USER_DIR + "/data/in/users.xml");
        Assertions.assertEquals(true, f.exists());
        System.out.println("Export /data/in/users.xml exists");
    }
}
