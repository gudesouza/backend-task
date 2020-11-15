package com.dekopay.services.exportation.impl.decorator;

import com.dekopay.services.exportation.FileHelper;

import java.util.Map;

public abstract class UserDecorator implements FileHelper {

    protected FileHelper decoratedFile;
    protected Map indexes;

    public UserDecorator(FileHelper fileHelper) {
        this.decoratedFile = fileHelper;
    }

    public void doWrite(Object data, String fileName) {
        decoratedFile.doWrite(data, fileName);
    }

    public abstract void setIndexes();
}
