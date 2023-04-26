package com.arun.transaction.Authentication.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ConnectionBuilder;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String email;
    private String password;
    private int phone;
    private String role;

    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate = new Date();


}
