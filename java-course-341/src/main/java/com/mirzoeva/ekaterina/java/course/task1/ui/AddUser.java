package com.mirzoeva.ekaterina.java.course.task1.ui;

import com.mirzoeva.ekaterina.java.course.task1.model.BankUser;
import com.mirzoeva.ekaterina.java.course.task1.service.BankUserService;
import com.mirzoeva.ekaterina.java.course.task1.service.db.BankUserServiceDbImpl;
import com.mirzoeva.ekaterina.java.course.task1.service.json.BankUserServiceJsonImpl;
import lombok.SneakyThrows;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author mirzoeva.ekaterina
 */
@WebServlet("/add-user")
public class AddUser extends HttpServlet {

    public static final String URL = "jsp/add-user.jsp";
    public static final String NAME_ATTR = "name";
    public static final String PASSWORD_ATTR = "password";
    public static final String ACCOUNT_NUMBER_ATTR = "accountNumber";
    public static final String AMOUNT_ATTR = "amount";

    private BankUserService bankUserService = new BankUserServiceDbImpl();

    @Override
    @SneakyThrows
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        req.getRequestDispatcher(URL).forward(req, resp);
    }

    @Override
    @SneakyThrows
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter(NAME_ATTR);
        String password = req.getParameter(PASSWORD_ATTR);
        String accountNumber = req.getParameter(ACCOUNT_NUMBER_ATTR);
        Integer amount = Integer.valueOf(req.getParameter(AMOUNT_ATTR));

        BankUser user = new BankUser(name, password, accountNumber, amount);
        bankUserService.save(user);

        resp.sendRedirect("/bank-users");
    }
}