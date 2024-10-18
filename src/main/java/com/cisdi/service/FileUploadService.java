package com.cisdi.service;

import java.io.InputStream;

/**
 * @author Heyinqing
 * @date 2024/10/10
 */
public interface FileUploadService {


    int resourceUploading(InputStream inputStream, String fileName) throws Exception;
}
