package com.huayutech.web.web.file;

import com.huayutech.web.config.StorageProperties;
import com.huayutech.web.service.StorageService;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.DigestUtils;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.security.MessageDigest;

@RestController
@RequestMapping("/files")

public class FileController {

    Logger logger = LoggerFactory.getLogger(getClass());



    @Autowired
    StorageService storageService;

    @PostMapping
    public ResponseEntity doPostFile(@RequestParam("File") MultipartFile file){



        storageService.store(file);


        return new ResponseEntity(HttpStatus.OK);


    }

}
