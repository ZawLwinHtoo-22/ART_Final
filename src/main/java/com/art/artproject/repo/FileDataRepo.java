package com.art.artproject.repo;

import com.art.artproject.entity.FileData;
import com.art.artproject.entity.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileDataRepo extends JpaRepository<FileData, Long> {
    Optional<FileData> findByName(String fileName);
}
