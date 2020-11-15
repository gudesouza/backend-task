package com.dekopay.services.importation.impl;

import com.dekopay.services.importation.ImportStrategy;

import java.util.ArrayList;

public class Import {

    private ImportStrategy importStrategy;

    public Import(ImportStrategy importStrategy) {
        this.importStrategy = importStrategy;
    }

    public ArrayList executeImport(String file, String entityName) {
        return importStrategy.doMapping(file, entityName);
    }
}
