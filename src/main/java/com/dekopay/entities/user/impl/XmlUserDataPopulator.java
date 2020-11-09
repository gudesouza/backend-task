package com.dekopay.entities.user.impl;

import com.dekopay.entities.user.User;
import com.dekopay.entities.user.UserDataPopulator;
import com.dekopay.services.impl.XmlDatasetHandler;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.Collection;
import java.util.Map;

public class XmlUserDataPopulator extends UserDataPopulator {

    private static final String USERS = "users";
    private static final String USER = "user";
    private static final String USER_ID = "userid";
    private static final String FIRST_NAME = "firstname";
    private static final String LAST_NAME = "surname";
    private static final String USERNAME = "username";
    private static final String USER_TYPE = "type";
    private static final String LAST_LOGIN_TIME = "lastlogintime";


    @Override
    public User populate(User user, Map data) {
        XmlDatasetHandler xmlDatasetHandler = new XmlDatasetHandler();
        Integer userId = Integer.parseInt(data.get(USER_ID).toString());
        user.setUserId(userId);
        user.setFirstName(data.get(FIRST_NAME).toString());
        user.setLastName(data.get(LAST_NAME).toString());
        user.setUsername(data.get(USERNAME).toString());
        user.setUserType(data.get(USER_TYPE).toString());
        user.setLastLoginTime(xmlDatasetHandler.converDateToIsoDate(data.get(LAST_LOGIN_TIME).toString()));
        return user;
    }

    @Override
    public Document mapUser(Collection<User> collection) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            // root element
            Element root = document.createElement(USERS);
            document.appendChild(root);

            for (User userObj : collection) {
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

            return document;

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        }
        return null;
    }
}
