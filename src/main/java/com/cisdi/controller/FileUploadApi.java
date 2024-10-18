package com.cisdi.controller;

import com.cisdi.common.ResultMsg;
import com.cisdi.service.FileUploadService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author Heyinqing
 * @date 2024/10/10
 */

@RestController
@RequestMapping("/file")
public class FileUploadApi {

    @Resource
    private FileUploadService fileUploadService;

    @PostMapping("/resourceUploading")
    public ResultMsg uploading(@RequestParam("file") MultipartFile file) throws Exception {
        // try {
            int a = fileUploadService.resourceUploading(file.getInputStream(),file.getOriginalFilename());
            if (a!=0){
                return ResultMsg.success();
            }
            return ResultMsg.fail(403,"导入失败");
        // }catch (Exception e){
        //     return ResultMsg.fail(String.format("数据导入失败：%s",e.getMessage()));
        // }

    }
}
