package com.skynet.http.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/dispatcher")
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("/flights")
//                .forward(req, resp);
//
//        req.getRequestDispatcher("/flights")
//                .include(req, resp);
//
//        PrintWriter writer = resp.getWriter();
//        writer.write("hello 2");

        resp.sendRedirect("/flights");

        System.out.println();

    }
}
