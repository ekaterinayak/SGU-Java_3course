package com.mirzoeva.ekaterina.java.course.task1.ui;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author mirzoeva.ekaterina
 */
@WebServlet("/simple-servlet")
public class SimpleServlet extends HttpServlet {

    public static final String HTML_MIME = "text/html";
    public static final String MESSAGE = "Hello, Servlets!";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(HTML_MIME);

        PrintWriter writer = resp.getWriter();
        writer.println(String.format("<h1>%s</h1>", MESSAGE));
    }
}
