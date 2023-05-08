package com.kinmel.Transaction.Service;

import com.kinmel.Transaction.Dto.UserAcccountDto;
import com.kinmel.Transaction.Model.UserAccount;
import com.kinmel.Transaction.Repo.TransactionRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService {



    @Autowired
    private TransactionRepo transactionRepo;

    public UserAccount findUserByPhone(String phone)throws Exception {

        UserAccount user = transactionRepo.findByPhone(Integer.parseInt(phone));
        if(user == null){
            return null;
        }
        return user;
    }

    public boolean checkPin(UserAcccountDto user, UserAccount userAccount) {
        if(user.getPin() == (userAccount.getPin())){
            return true;
        }
        else
            return false;
    }

    @Transactional
    public String transaction_process(UserAcccountDto user, UserAccount userAccount) {
       if(user.getPrice() >  userAccount.getBalance() ){
            return "Insuffiecent Balance";
       }else {

           String new_amount = String.valueOf((userAccount.getBalance()) - (user.getPrice()));
            transactionRepo.updateAmount(userAccount.getPhone() , new_amount);
            return "Transaction success";
       }

    }


}
