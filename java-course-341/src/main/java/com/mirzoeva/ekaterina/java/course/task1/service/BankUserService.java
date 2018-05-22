package com.mirzoeva.ekaterina.java.course.task1.service;

import com.mirzoeva.ekaterina.java.course.task1.model.BankUser;

import java.util.List;

/**
 * @author mirzoeva.ekaterina
 */
public interface BankUserService {

    List<BankUser> list();

    void save(BankUser bankUser);
}
