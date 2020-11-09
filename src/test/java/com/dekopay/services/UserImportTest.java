package com.dekopay.services;

import com.dekopay.entities.user.User;
import com.dekopay.services.impl.UserImportManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;

public class UserImportTest {

    @Test
    public void testImporData() {
        UserImportManager userImportManager = new UserImportManager();
        Collection collection = userImportManager.importData();
        Assertions.assertEquals(10, collection.size());
    }

    @Test
    public void testOrderOfData() {
        UserImportManager userImportManager = new UserImportManager();
        Collection collection = userImportManager.importData();
        int i = 1;
        for (User user : (Collection<User>) collection ) {
            Assertions.assertEquals(i, user.getUserId());
            System.out.println(user.getUserId());
            i++;
        }
    }
}
