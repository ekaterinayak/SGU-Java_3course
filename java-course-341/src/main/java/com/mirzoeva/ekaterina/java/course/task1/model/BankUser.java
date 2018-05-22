package com.mirzoeva.ekaterina.java.course.task1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author mirzoeva.ekaterina
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankUser {

    private String id;
    private String name;
    private String password;
    private String accountNumber;
    private Integer amount;

    public BankUser(String name, String password, String accountNumber, Integer amount) {
        this.name = name;
        this.password = password;
        this.accountNumber = accountNumber;
        this.amount = amount;
    }
}
