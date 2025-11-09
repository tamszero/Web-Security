package com.example.xss.XSS.repository;

import com.example.xss.XSS.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //취약점 구현: Native Query를 사용해 문자열 직접 조합하는 방식
    @Query(value = "SELECT * From App_User WHERE username = :username AND password = :password", nativeQuery = true)
    Optional<User> findVulnerableUser(@Param("username") String username, @Param("password") String password);

    Optional<User> findByUsername(String username);
}
