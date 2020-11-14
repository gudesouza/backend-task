package com.dekopay.services.datasetformation;

import com.dekopay.constants.FileConstants;
import com.dekopay.services.importation.impl.CsvMapping;
import com.dekopay.services.importation.impl.Import;
import com.dekopay.services.importation.impl.JsonMapping;
import com.dekopay.services.importation.impl.XmlMapping;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class UserDatasetImportTest {

    @Test
    public void testUserCsvImport() {
        String file = FileConstants.USER_DIR + FileConstants.INPUT_FILE_DIR + "/users.csv";
        Import csvImport = new Import(new CsvMapping());
        ArrayList<Map> datasetList = csvImport.executeImport(file, "user");

        for (Object xmlDatasetMap : datasetList) {
            Iterator<Map.Entry<String, String>> iterator = ((Map) xmlDatasetMap).entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }
    }

    @Test
    public void testUserJsonImport() {
        String file = FileConstants.USER_DIR + FileConstants.INPUT_FILE_DIR + "/users.json";
        Import jsonImport = new Import(new JsonMapping());
        ArrayList<Map> datasetList = jsonImport.executeImport(file, "user");
        for (Object xmlDatasetMap : datasetList) {
            Iterator<Map.Entry<String, String>> iterator = ((Map) xmlDatasetMap).entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }
    }

    @Test
    public void testUserXmlImport() {
        String file = FileConstants.USER_DIR + FileConstants.INPUT_FILE_DIR + "/users.xml";
        Import xmlImport = new Import(new XmlMapping());
        ArrayList<Map> datasetList = xmlImport.executeImport(file, "user");
        for (Object xmlDatasetMap : datasetList) {
            Iterator<Map.Entry<String, String>> iterator = ((Map) xmlDatasetMap).entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }
    }
}
