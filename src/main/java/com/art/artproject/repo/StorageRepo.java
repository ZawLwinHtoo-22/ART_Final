package com.art.artproject.repo;

import com.art.artproject.entity.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StorageRepo extends JpaRepository<ImageData, Long> {

    Optional<ImageData> findByName(String fileName);
}
