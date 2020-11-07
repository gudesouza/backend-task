package com.dekopay.services;

import com.dekopay.constants.FileConstants;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XmlDatasetHandlerTest {

    @Test
    public void testReadXmlDataset() {
        try {
            String xmlPath = FileConstants.USER_DIR + "/data/in/users.xml";
            File fXmlFile = new File(xmlPath);
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlPath);

            System.out.println("Root Element :" + document.getDocumentElement().getNodeName());

            NodeList nodeList = document.getElementsByTagName("user");
            System.out.println("----------------------------");

            for (int elementBlock = 0; elementBlock < nodeList.getLength(); elementBlock++ ) {
                Node node = nodeList.item(elementBlock);
                System.out.println("\nCurrent Element Block : " + node.getNodeName());
                Element element = (Element) node;
                System.out.println("userid: " + element.getElementsByTagName("userid").item(0).getTextContent());
                System.out.println("firstname: " + element.getElementsByTagName("firstname").item(0).getTextContent());
                System.out.println("surname: " + element.getElementsByTagName("surname").item(0).getTextContent());
                System.out.println("username: " + element.getElementsByTagName("username").item(0).getTextContent());
                System.out.println("type:" + element.getElementsByTagName("type").item(0).getTextContent());
                System.out.println("lastlogintime: " + element.getElementsByTagName("lastlogintime").item(0).getTextContent());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
