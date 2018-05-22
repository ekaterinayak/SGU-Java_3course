package com.mirzoeva.ekaterina.java.course.task1.ui;

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
@WebServlet("/bank-users")
public class BankUsers extends HttpServlet {

    public static final String URL = "jsp/bank-users.jsp";

    private BankUserService bankUserService = new BankUserServiceDbImpl();

    @Override
    @SneakyThrows
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("users", bankUserService.list());
        req.getRequestDispatcher(URL).forward(req, resp);
    }
}
