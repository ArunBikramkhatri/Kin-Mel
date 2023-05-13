package com.arun.transaction.Authentication.Repo;

import com.arun.transaction.Authentication.Models.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserInfo, String> {

    @Query("select u from UserInfo u where u.email = :email")
    public UserInfo findByEMail(@Param("email") String email);

}
