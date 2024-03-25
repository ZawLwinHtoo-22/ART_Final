package com.art.artproject.repo;

import com.art.artproject.dto.UserNameResponse;
import com.art.artproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findUsersByMailAndPassword(String mail,String password);
    @Query("SELECT new com.art.artproject.dto.UserNameResponse(u.userName) FROM User u WHERE u.id = :id")
    Optional<UserNameResponse> findUserNameById(@Param("id") Long id);


}
