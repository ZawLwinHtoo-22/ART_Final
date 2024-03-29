package com.art.artproject.utils;

import com.art.artproject.constant.FileConstant;
import io.micrometer.common.util.StringUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class FileUtils {

    private static final String defaultPath = FileConstant.DEFAULT_PATH;
    private Path foundFile;

    public static String save(MultipartFile file){

        String resultPath = "";

        try {

            if(!StringUtils.isBlank(file.getOriginalFilename())) {
                File directory = new File(defaultPath);
                if (!directory.exists()) {
                    directory.mkdirs();
                }

                String fileName = file.getOriginalFilename();

                resultPath = UUID.randomUUID() + fileName;

                File destFile = new File(defaultPath + "/" + resultPath);
                file.transferTo(destFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultPath;
    }

    public Resource getFileAsResource(String fileCode) throws IOException {
        Path dirPath = Paths.get(FileConstant.DEFAULT_PATH);

        Files.list(dirPath).forEach(file -> {
            if (file.getFileName().toString().startsWith(fileCode)) {
                foundFile = file;
                return;
            }
        });

        if (foundFile != null) {
            return new UrlResource(dirPath.resolve(foundFile).toUri());
        }

        return null;
    }
}
