package com.dekopay.services;

import com.dekopay.constants.FileConstants;
import com.dekopay.services.impl.CsvDatasetHandler;
import com.dekopay.services.impl.JsonDatasetHandler;
import com.dekopay.services.impl.XmlDatasetHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.*;

public class DatasetHandlerTest {

    @Test
    public void testReadXmlDataset() {
        String xmlFile = FileConstants.USER_DIR + "/data/in/users.xml";
        ArrayList xmlDatasetList = new XmlDatasetHandler().readDataset(xmlFile);
        for (Object xmlDatasetMap : xmlDatasetList) {
            Iterator<Map.Entry<String, String>> iterator = ((Map) xmlDatasetMap).entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }
    }
    @Test
    public void testReadCsvDataset() {
        String csvFile = FileConstants.USER_DIR + "/data/in/users.csv";
        ArrayList xmlDatasetList = new CsvDatasetHandler().readDataset(csvFile);
        for (Object xmlDatasetMap : xmlDatasetList) {
            Iterator<Map.Entry<String, String>> iterator = ((Map) xmlDatasetMap).entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }

    }

    @Test
    public void testReadJsonDataset() {
        String jsonFile = FileConstants.USER_DIR + "/data/in/users.json";
        ArrayList xmlDatasetList = new JsonDatasetHandler().readDataset(jsonFile);
        for (Object xmlDatasetMap : xmlDatasetList) {
            Iterator<Map.Entry<String, String>> iterator = ((Map) xmlDatasetMap).entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }

    }

    @Test
    public void testConverDateToIsoDate() {
        DatasetHandler datasetHandler = new CsvDatasetHandler();
        String convertedDate = datasetHandler.converDateToIsoDate("12-01-2015 12:01:34"); //2015-01-12T01:01:34.000+01:00
        Assertions.assertEquals("2015-01-12T01:01:34.000+01:00", convertedDate);
    }


}
