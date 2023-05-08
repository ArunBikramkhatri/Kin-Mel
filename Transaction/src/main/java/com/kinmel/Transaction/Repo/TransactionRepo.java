package com.kinmel.Transaction.Repo;

import com.kinmel.Transaction.Model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface TransactionRepo extends JpaRepository<UserAccount , String> {

    @Query("select u from UserAccount u where u.phone=:phone")
    UserAccount findByPhone(@Param("phone") int phone);

    @Query("UPDATE UserAccount u set u.balance = :amount where u.phone  = :phone")
    void updateAmount(int phone ,String amount);


}
