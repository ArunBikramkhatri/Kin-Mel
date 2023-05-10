package com.kinmel.Transaction.Controller;

import com.kinmel.Transaction.Dto.UserAcccountDto;
import com.kinmel.Transaction.Model.UserAccount;
import com.kinmel.Transaction.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kin-mel")
public class PaymentController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/pay")
    public ResponseEntity<String> payment_process(@RequestBody UserAcccountDto user) throws Exception {

        UserAccount userAccount = transactionService.findUserByPhone(String.valueOf(user.getPhone()));
        System.out.println(userAccount);
        if(userAccount != null){
            if(transactionService.checkPin(user , userAccount)){

                String status = transactionService.transaction_process(user , userAccount);

                return ResponseEntity.ok(status);
            }
            else
            {
                return ResponseEntity.ok("Pin is wrong");
            }


        }else {
            return ResponseEntity.ok("User not found");
        }

    }
}
