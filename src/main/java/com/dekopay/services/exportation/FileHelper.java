package com.dekopay.services.exportation;

import java.util.Collection;
import java.util.List;

public interface FileHelper {
    void doWrite(Object data, String fileName, List header);
}
