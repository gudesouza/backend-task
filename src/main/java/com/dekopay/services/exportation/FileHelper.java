package com.dekopay.services.exportation;

import java.util.Collection;
import java.util.List;

public interface FileHelper {
    void doWrite(Collection data, String fileName, List header);
}
