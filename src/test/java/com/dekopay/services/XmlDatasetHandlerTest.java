package com.dekopay.services;

import com.dekopay.constants.FileConstants;
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

public class XmlDatasetHandlerTest {

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

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile))) {
            Boolean hasHeader = true;
            String line = "";
            String cvsSplitBy = ",";
            List<String> dataset = new ArrayList<>();
            //skip the first line
            if (hasHeader) {
                bufferedReader.readLine();
            }
            while ((line = bufferedReader.readLine()) != null) {

                // use comma as separator
                String[] lineItem = line.split(cvsSplitBy);
                for (String value : lineItem) {
                    dataset.add(value);
                    System.out.println("value: " + value);
                }


/*
                System.out.println("userid: " + lineItem[0]);
                System.out.println("firstname: " + lineItem[1]);
                System.out.println("surname: " + lineItem[2]);
                System.out.println("username: " + lineItem[3]);
                System.out.println("type: " + lineItem[4]);
                System.out.println("lastlogintime: " + lineItem[5]);
                System.out.println();
 */


            }

        } catch (IOException e) {
            e.printStackTrace();
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
