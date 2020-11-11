package com.dekopay.services.datasetformation.impl;

import com.dekopay.services.datasetformation.XmlReader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserXmlReader implements XmlReader {

    @Override
    public ArrayList read(String file) {
        //instantiate an ArrayList object so that we can add Map object into it
        ArrayList<Map> datasetList = new ArrayList<>();

        // start the process of reading the xml dataset
        try {
            //load xml file
            File fXmlFile = new File(file);
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(fXmlFile);

            // start the pointer from the user node
            NodeList nodeList = document.getElementsByTagName("user");

            //loop the node elements
            for (int i = 0; i < nodeList.getLength(); i++ ) {
                //instantiate an datasetMap with Hash Map so thet we can add keypair value
                Map<String,String> datasetMap = new HashMap<>();

                //dynamically assign the node
                Node node = nodeList.item(i);
                Element element = (Element) node;

                //start digging into the child nodes
                NodeList childNodelist = element.getChildNodes();

                for (int j = 0; j < childNodelist.getLength(); j++) {
                    //dynamically assign child node so we can get all the fields from the xml file
                    Node childNode = childNodelist.item(j);

                    if (childNode.hasChildNodes() || childNode.getNodeType()!=3) {
                        //put into the keypair Map the field name and its value
                        datasetMap.put(childNode.getNodeName(),childNode.getTextContent());
                    }
                }
                //now it's time to add the dataset Map into the ArrayList
                datasetList.add(datasetMap);
            }
            return datasetList;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
