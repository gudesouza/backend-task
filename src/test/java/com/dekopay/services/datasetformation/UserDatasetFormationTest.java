package com.dekopay.services.datasetformation;

import com.dekopay.services.datasetformation.impl.UserDatasetFormationManager;
import org.junit.jupiter.api.Test;

public class UserDatasetFormationTest {

    @Test
    public void testUserCsvReader() {
        UserDatasetFormationManager userDatasetFormationManager = new UserDatasetFormationManager();
        //userDatasetFormationManager.getCsvReader().read(file);
    }

    @Test
    public void testUserJsonReader() {
        UserDatasetFormationManager userDatasetFormationManager = new UserDatasetFormationManager();
        //userDatasetFormationManager.getJsonReader().read(file);
    }

    @Test
    public void testUserXmlReader() {
        UserDatasetFormationManager userDatasetFormationManager = new UserDatasetFormationManager();
        //userDatasetFormationManager.getXmlReader().read(file);
    }
}
