package com.dekopay.services.importation.impl.decorator;

import com.dekopay.services.importation.IndexHeader;

import java.util.Map;

public class IndexHeaderDecorator implements IndexHeader {

    protected IndexHeader decoratedIndexHeader;

    public IndexHeaderDecorator(IndexHeader decoratedIndexHeader) {
        this.decoratedIndexHeader = decoratedIndexHeader;
    }

    @Override
    public Map<String, String> getData() {
        return decoratedIndexHeader.getData();
    }

}
