package com.dekopay.services.exportation.impl;

import com.dekopay.constants.FileConstants;
import com.dekopay.services.exportation.FileHelper;
import com.dekopay.services.exportation.XmlExporter;
import com.dekopay.services.exportation.impl.decorator.XmlFileUserDecorator;
import com.dekopay.services.exportation.impl.decorator.XmlWriter;
import java.util.Collection;

public class UserXmlExporter implements XmlExporter {

    @Override
    public void export(Collection data) {
        System.out.println("Start Exporting Process XML...");

        FileHelper xmlWriter = new XmlWriter();
        FileHelper xmlUserFile = new XmlFileUserDecorator(xmlWriter);
        xmlUserFile.doWrite(data, FileConstants.USERS_EXPORT_NAME);

    }

}
