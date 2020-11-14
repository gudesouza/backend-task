package com.dekopay.services.exportation.impl.decorator;

import com.dekopay.constants.FileConstants;
import com.dekopay.entities.user.impl.JsonUserDataPopulator;
import com.dekopay.entities.user.impl.XmlUserDataPopulator;
import com.dekopay.services.exportation.FileHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.w3c.dom.Document;

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

public class XmlWriter implements FileHelper {

    @Override
    public void doWrite(Collection data, String fileName, List headers) {

        //start exporting
        System.out.println("Start Writing to Xml...");
        /**
         * @// TODO: 13/11/2020 need to refactor this implementation for populating the data
         */
        XmlUserDataPopulator xmlUserDataPopulator = new XmlUserDataPopulator();
        Document document = xmlUserDataPopulator.mapUser(data, headers);

        try {
            // create the xml file
            //transform the DOM Object to an XML File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(FileConstants.USER_DIR + FileConstants.OUTPUT_FILE_DIR + "/" + fileName + FileConstants.XML_EXTENSION));

            transformer.transform(domSource, streamResult);

            System.out.println("Successfully Saved XML file...");

        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }

    }

}
