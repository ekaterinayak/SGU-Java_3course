package com.mirzoeva.ekaterina.ssu.internet.bank.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author mirzoeva.ekaterina
 */
@Entity
@Table(name = "BANK_OPERATION")
@Data
public class BankOperation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "SENDER_ID")
    private BankAccount sender;

    @ManyToOne
    @JoinColumn(name = "RECEIVER_ID")
    private BankAccount receiver;

    private Long amount;

    @Column(name = "IS_REVERSE")
    private Boolean reverse;
}
