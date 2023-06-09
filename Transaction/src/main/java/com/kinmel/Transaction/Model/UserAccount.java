package com.kinmel.Transaction.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id ;
    private String username ;
    private int pin;
    private Long phone;
    private int balance;
}
