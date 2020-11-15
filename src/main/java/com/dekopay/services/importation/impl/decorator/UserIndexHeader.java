package com.dekopay.services.importation.impl.decorator;

import com.dekopay.services.importation.IndexHeader;

import java.util.HashMap;
import java.util.Map;

public class UserIndexHeader implements IndexHeader {
    @Override
    public Map<String, String> getData() {
        Map<String, String> indexes = new HashMap<>();
        return indexes;
    }
}
