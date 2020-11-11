package com.dekopay.services.exportation.impl;

import com.dekopay.constants.FileConstants;
import com.dekopay.entities.user.impl.XmlUserDataPopulator;
import com.dekopay.services.exportation.XmlExporter;
import org.w3c.dom.Document;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Collection;

public class UserXmlExporter implements XmlExporter {

    @Override
    public void export(Collection data) {
        System.out.println("Start Exporting User XML...");
        XmlUserDataPopulator xmlUserDataPopulator = new XmlUserDataPopulator();
        Document document = (Document) xmlUserDataPopulator.mapUser(data);
        this.writeToFile(document, FileConstants.USERS_EXPORT_NAME);
    }

    public void writeToFile(Document document, String fileName) {

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
