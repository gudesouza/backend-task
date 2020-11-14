package com.dekopay.services.exportation.impl.decorator;

import com.dekopay.entities.user.User;
import com.dekopay.services.exportation.FileHelper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class XmlFileUserDecorator extends UserDecorator {

    private static final String USERS = "users";
    private static final String USER = "user";
    //headers
    private static final String USER_ID = "userid";
    private static final String FIRST_NAME = "firstname";
    private static final String LAST_NAME = "surname";
    private static final String USERNAME = "username";
    private static final String USER_TYPE = "type";
    private static final String LAST_LOGIN_TIME = "lastlogintime";

    public XmlFileUserDecorator(FileHelper fileHelper) {
        super(fileHelper);
    }

    @Override
    public void doWrite(Object data, String fileName, List headers) {

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
                Element userId = document.createElement(USER_ID);
                userId.appendChild(document.createTextNode(userObj.getUserId().toString()));
                user.appendChild(userId);

                // firstname element
                Element firstName = document.createElement(FIRST_NAME);
                firstName.appendChild(document.createTextNode(userObj.getFirstName()));
                user.appendChild(firstName);

                // surname element
                Element lastName = document.createElement(LAST_NAME);
                lastName.appendChild(document.createTextNode(userObj.getLastName()));
                user.appendChild(lastName);

                // username element
                Element username = document.createElement(USERNAME);
                username.appendChild(document.createTextNode(userObj.getUsername()));
                user.appendChild(username);

                // type elements
                Element userType = document.createElement(USER_TYPE);
                userType.appendChild(document.createTextNode(userObj.getUserType()));
                user.appendChild(userType);

                // lastlogintime elements
                Element lastLoginTime = document.createElement(LAST_LOGIN_TIME);
                lastLoginTime.appendChild(document.createTextNode(userObj.getLastLoginTime()));
                user.appendChild(lastLoginTime);
            }

            decoratedFile.doWrite(document, fileName, getXmlHeaders());

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        }

    }

    /**
     * This can be used by populator
     * @return
     */
    public List getXmlHeaders() {
        return Arrays.asList(USER_ID, FIRST_NAME, LAST_NAME, USERNAME, USER_TYPE, LAST_LOGIN_TIME);
    }

}
