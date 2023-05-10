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

        UserAccount user = transactionRepo.findByPhone(Long.parseLong(phone));
        if(user == null){
            return null;
        }
        return user;
    }

    public boolean checkPin(UserAcccountDto userDto, UserAccount userAccount) {
        if(Integer.parseInt(userDto.getPin()) == (userAccount.getPin())){
            return true;
        }
        else
            return false;
    }

    @Transactional
    public String transaction_process(UserAcccountDto userDto, UserAccount userAccount) {
       if(Integer.parseInt(userDto.getPrice()) >  userAccount.getBalance() ){
            return "Insuffiecent Balance";
       }else {

           int new_amount = (userAccount.getBalance()) - (Integer.parseInt(userDto.getPrice()));
            transactionRepo.updateAmount(userAccount.getPhone() , new_amount);
            return "Transaction success";
       }

    }


}
