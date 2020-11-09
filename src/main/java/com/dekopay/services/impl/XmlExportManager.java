package com.dekopay.services.impl;

import com.dekopay.constants.FileConstants;
import com.dekopay.entities.user.impl.JsonUserDataPopulator;
import com.dekopay.entities.user.impl.XmlUserDataPopulator;
import com.dekopay.services.ExportManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class XmlExportManager implements ExportManager {
    @Override
    public void exportData(Collection collection) throws IOException {

        XmlUserDataPopulator xmlUserDataPopulator = new XmlUserDataPopulator();
        //List<List<String>> dataLines = jsonUserDataPopulator.mapUser(collection);
        Document document = (Document) xmlUserDataPopulator.mapUser(collection);
        this.writeToFile(document, "users");

    }

    protected void writeToFile(Document document, String fileName) throws IOException {
        //FileWriter xmlWriter = new FileWriter(FileConstants.USER_DIR + FileConstants.OUTPUT_FILE_DIR + "/" + fileName + FileConstants.XML_EXTENSION);

        try {
            // create the xml file
            //transform the DOM Object to an XML File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(FileConstants.USER_DIR + FileConstants.OUTPUT_FILE_DIR + "/" + fileName + FileConstants.XML_EXTENSION));

            // If you use
            // StreamResult result = new StreamResult(System.out);
            // the output will be pushed to the standard output ...
            // You can use that for debugging

            transformer.transform(domSource, streamResult);

            System.out.println("Successfully Saved XML file...");

        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }








        System.out.println("Successfully Saved JSON file...");
    }
}
