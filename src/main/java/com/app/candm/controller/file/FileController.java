package com.app.candm.controller.file;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/files/**")
public class FileController {

    @Value("${file.upload-path}")
    private String uploadPath;

    @GetMapping("display")
    public byte[] display(String filePath, String fileName) throws IOException {
        return FileCopyUtils.copyToByteArray(new File(uploadPath + filePath, fileName));
    }
}