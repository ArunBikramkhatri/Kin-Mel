package com.kinmel.Transaction.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserAcccountDto {

    private String phone;
    private String pin;
    private String price;

}
