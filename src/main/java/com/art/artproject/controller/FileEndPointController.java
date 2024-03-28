package com.art.artproject.controller;


import com.art.artproject.entity.FileExtentionMapper;
import com.art.artproject.entity.FileUtils;

import org.springframework.core.io.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/storage")
public class FileEndPointController {

    @PostMapping("/upload")
    public String saveFile(@RequestParam MultipartFile file){
        return FileUtils.save(file);
    }

    @GetMapping("/download")
    public ResponseEntity<?> downloadFile(@RequestParam String filePath) {
        FileUtils downloadUtil = new FileUtils();

        Resource resource;
        try {
            resource = downloadUtil.getFileAsResource(filePath);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }

        if (resource == null) {
            return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);
        }

        String fName = resource.getFilename();
        MediaType mediaType = FileExtentionMapper.getMediaTypeForFileName(filePath);
        String contentType = mediaType.toString();
        String headerValue = "attachment; filename=\"" + fName + "\"";

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                .body(resource);
    }


}
