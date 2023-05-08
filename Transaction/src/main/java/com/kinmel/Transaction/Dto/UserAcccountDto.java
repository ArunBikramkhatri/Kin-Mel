package com.kinmel.Transaction.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserAcccountDto {

    private int phone;
    private int pin;
    private int price;

}
