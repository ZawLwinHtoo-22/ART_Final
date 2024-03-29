package com.art.artproject.repo;

import com.art.artproject.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {
    Optional<Admin> findAdminByMailAndPassword(String mail,String password);
}
