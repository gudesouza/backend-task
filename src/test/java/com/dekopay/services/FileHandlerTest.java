package com.dekopay.services;

import com.dekopay.constants.FileConstants;
import com.dekopay.services.impl.UserFileHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FileHandlerTest {
    @Test
    public void testLoadUsersFiles() {
        System.out.println("Start testing Load UserFiles");

        List<String> expectedList = new ArrayList<String>();
        expectedList.add(FileConstants.USER_DIR + "/data/in/users.csv");
        expectedList.add(FileConstants.USER_DIR + "/data/in/users.json");
        expectedList.add(FileConstants.USER_DIR + "/data/in/users.xml");
        expectedList.forEach(System.out::println);

        List<String> fileList = new UserFileHandler().getFiles();

        Assertions.assertLinesMatch(expectedList, fileList);


    }




}
