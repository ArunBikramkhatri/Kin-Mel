package com.kinmel.Transaction.Repo;

import com.kinmel.Transaction.Model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepo extends JpaRepository<UserAccount , String> {

    @Query("select u from UserAccount u where u.phone=:phone")
    UserAccount findByPhone(@Param("phone") Long phone);

    @Modifying
    @Query("UPDATE UserAccount u set u.balance = :amount where u.phone  = :phone")
    void updateAmount(Long phone ,@Param("amount") int amount);


    @Query("select u from UserAccount  u where u.phone=:phone")
    UserAccount getUserByPhone(@Param("phone") Long phone);
}
