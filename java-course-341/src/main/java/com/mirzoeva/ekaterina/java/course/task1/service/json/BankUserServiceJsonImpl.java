package com.mirzoeva.ekaterina.java.course.task1.service.json;

import com.mirzoeva.ekaterina.java.course.task1.model.BankUser;
import com.mirzoeva.ekaterina.java.course.task1.service.BankUserService;
import com.mirzoeva.ekaterina.java.course.task1.util.JSONUtils;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

/**
 * @author mirzoeva.ekaterina
 */
public class BankUserServiceJsonImpl implements BankUserService {

    private static final String FILE_NAME = "users.json";

    @Override
    public List<BankUser> list() {
        return JSONUtils.read(FILE_NAME);
    }

    @Override
    public void save(BankUser bankUser) {
        if (bankUser.getId() == null) {
            bankUser.setId(UUID.randomUUID().toString());
        }

        List<BankUser> users = new ArrayList<>(list());
        users.add(bankUser);

        JSONUtils.write(FILE_NAME, users);
    }
}
