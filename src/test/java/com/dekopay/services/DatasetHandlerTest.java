package com.dekopay.services;

import com.dekopay.constants.FileConstants;
import com.dekopay.services.impl.CsvDatasetHandler;
import com.dekopay.services.impl.JsonDatasetHandler;
import com.dekopay.services.impl.XmlDatasetHandler;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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


}
