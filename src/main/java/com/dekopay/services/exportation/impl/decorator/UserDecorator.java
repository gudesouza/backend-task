package com.dekopay.services.exportation.impl.decorator;

import com.dekopay.entities.user.User;
import com.dekopay.services.exportation.FileHelper;

import java.util.Collection;
import java.util.List;

public abstract class UserDecorator implements FileHelper {

    protected FileHelper decoratedFile;

    public UserDecorator(FileHelper fileHelper) {
        this.decoratedFile = fileHelper;
    }

    public void doWrite(Object data, String fileName) {
        decoratedFile.doWrite(data, fileName, null);
    }
}
