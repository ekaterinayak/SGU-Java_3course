package com.mirzoeva.ekaterina.java.course.task1.ui;

import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

/**
 * @author mirzoeva.ekaterina
 */
@WebServlet("/simple-jsp")
public class SimpleJsp extends HttpServlet {

    public static final String SUCCESSFUL_RESULT = "You'll have a luck day!";
    public static final String FAILED_RESULT = "Well, life goes on ...";
    public static final String NUMBER_ATTR = "number";
    public static final String MESSAGE_ATTR = "message";
    public static final String URL = "jsp/simple-jsp.jsp";

    private double coefficient;

    @Override
    public void init() throws ServletException {
        super.init();
        coefficient = 0.95;
    }

    @Override
    @SneakyThrows
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        double randomNumber = generateRandomNumber();
        req.setAttribute(NUMBER_ATTR, randomNumber);
        req.setAttribute(MESSAGE_ATTR, getMessage(randomNumber));
        req.getRequestDispatcher(URL).forward(req, resp);
    }

    @Override
    @SneakyThrows
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doGet(req, resp);
    }

    private String getMessage(Double randomNumber) {
        if (randomNumber > coefficient) {
            return SUCCESSFUL_RESULT;
        }
        return FAILED_RESULT;
    }

    private static double generateRandomNumber() {
        return (new Random()).doubles(0.2, 1.5)
                .findFirst()
                .getAsDouble();
    }
}
