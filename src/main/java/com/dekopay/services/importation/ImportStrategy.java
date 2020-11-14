package com.dekopay.services.importation;

import java.util.ArrayList;

public interface ImportStrategy {
    ArrayList doMapping(String file, String entityName);
}
