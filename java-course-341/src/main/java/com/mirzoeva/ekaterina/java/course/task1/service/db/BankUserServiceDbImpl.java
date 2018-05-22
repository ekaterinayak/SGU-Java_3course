package com.mirzoeva.ekaterina.java.course.task1.service.db;

import com.mirzoeva.ekaterina.java.course.task1.model.BankUser;
import com.mirzoeva.ekaterina.java.course.task1.service.BankUserService;
import lombok.SneakyThrows;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

/**
 * @author mirzoeva.ekaterina
 */
public class BankUserServiceDbImpl implements BankUserService {

    private Connection connection;

    @SneakyThrows
    public BankUserServiceDbImpl() {
        Properties properties = new Properties();
        properties.load(BankUserServiceDbImpl.class.getResourceAsStream("/application.properties"));

        String driverClassName = properties.getProperty("datasource.driverClassName");
        String url = properties.getProperty("datasource.url");
        String username = properties.getProperty("datasource.username");
        String password = properties.getProperty("datasource.password");

        Class.forName(driverClassName);

        connection = DriverManager.getConnection(url, username, password);

        createItemTable();
    }

    private void createItemTable() {
        String sqlQuery = "CREATE TABLE IF NOT EXISTS user (" +
                "id VARCHAR(255) NOT NULL," +
                "name VARCHAR(255) NOT NULL," +
                "password VARCHAR(255) NOT NULL," +
                "account_number VARCHAR(255) NOT NULL," +
                "amount INT NOT NULL," +
                "PRIMARY KEY (id)" +
                ")";
        createTableExecutor(sqlQuery);
    }

    @SneakyThrows
    private void createTableExecutor(String sqlQuery) {
        Statement statement = connection.createStatement();
        statement.executeUpdate(sqlQuery);
        statement.close();
    }

    @SneakyThrows
    @Override
    public List<BankUser> list() {
        List<BankUser> users = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String password = resultSet.getString("password");
            String accountNumber = resultSet.getString("account_number");
            int amount = resultSet.getInt("amount");


            users.add(new BankUser(id, name, password, accountNumber, amount));
        }
        return users;
    }

    @SneakyThrows
    @Override
    public void save(BankUser bankUser) {
        if (bankUser.getId() == null) {
            bankUser.setId(UUID.randomUUID().toString());
        }

        Statement statement = connection.createStatement();
        String insertLine = String.format("INSERT INTO user VALUES ('%s', '%s', '%s', '%s', %d)",
                bankUser.getId(),
                bankUser.getName(),
                bankUser.getPassword(),
                bankUser.getAccountNumber(),
                bankUser.getAmount());
        statement.executeUpdate(insertLine);
    }
}
