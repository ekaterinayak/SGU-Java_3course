package com.mirzoeva.ekaterina.ssu.internet.bank.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mirzoeva.ekaterina
 */
@Entity
@Data
@Table(name = "USER")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String login;

    private String password;

    private String name;

    private String surname;

    private String patronymic;

    private String address;

    @Column(name = "IS_ADMIN")
    private boolean admin;

    @OneToMany(mappedBy = "owner")
    private List<BankAccount> accounts = new ArrayList<>();
}
