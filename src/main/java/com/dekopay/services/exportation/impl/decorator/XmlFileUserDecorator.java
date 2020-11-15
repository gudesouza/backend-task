package com.dekopay.services.exportation.impl.decorator;

import com.dekopay.entities.user.User;
import com.dekopay.services.exportation.FileHelper;
import com.dekopay.services.importation.impl.decorator.IndexHeaderDecorator;
import com.dekopay.services.importation.impl.decorator.UserIndexHeader;
import com.dekopay.services.importation.impl.decorator.UserJsonIndexHeaderDecorator;
import com.dekopay.services.importation.impl.decorator.UserXmlIndexHeaderDecorator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.*;

public class XmlFileUserDecorator extends UserDecorator {

    private static final String USERS = "users";
    private static final String USER = "user";

    public XmlFileUserDecorator(FileHelper fileHelper) {
        super(fileHelper);
    }

    @Override
    public void doWrite(Object data, String fileName) {

        //set the indexes before assigning them
        setIndexes();

        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            // root element
            Element root = document.createElement(USERS);
            document.appendChild(root);

            for (User userObj : (Collection<User>)data) {
                // user elements
                Element user = document.createElement(USER);
                root.appendChild(user);

                // userid element (Id needs to convert to string)
                Element userId = document.createElement(indexes.get("USER_ID").toString());
                userId.appendChild(document.createTextNode(userObj.getUserId().toString()));
                user.appendChild(userId);

                // firstname element
                Element firstName = document.createElement(indexes.get("FIRST_NAME").toString());
                firstName.appendChild(document.createTextNode(userObj.getFirstName()));
                user.appendChild(firstName);

                // surname element
                Element lastName = document.createElement(indexes.get("LAST_NAME").toString());
                lastName.appendChild(document.createTextNode(userObj.getLastName()));
                user.appendChild(lastName);

                // username element
                Element username = document.createElement(indexes.get("USERNAME").toString());
                username.appendChild(document.createTextNode(userObj.getUsername()));
                user.appendChild(username);

                // type elements
                Element userType = document.createElement(indexes.get("USER_TYPE").toString());
                userType.appendChild(document.createTextNode(userObj.getUserType()));
                user.appendChild(userType);

                // lastlogintime elements
                Element lastLoginTime = document.createElement(indexes.get("LAST_LOGIN_TIME").toString());
                lastLoginTime.appendChild(document.createTextNode(userObj.getLastLoginTime()));
                user.appendChild(lastLoginTime);
            }

            decoratedFile.doWrite(document, fileName);

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        }

    }

    @Override
    public void setIndexes() {
        IndexHeaderDecorator userXmlIndexHeaderDecorator = new IndexHeaderDecorator(new UserXmlIndexHeaderDecorator(new UserIndexHeader()));
        Map indexes = userXmlIndexHeaderDecorator.getData();
        super.indexes = indexes;
    }

}
