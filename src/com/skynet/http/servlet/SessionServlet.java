package com.skynet.http.servlet;

import com.skynet.http.dto.UserDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/sessions")
public class SessionServlet extends HttpServlet {

    public static final String USER = "user";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        var user = (UserDto) session.getAttribute(USER);
        System.out.println(session.isNew());

        if (user == null) {
            user = UserDto.builder()
                    .id(25)
                    .email("test@gmail.com")
                    .build();
        }

        session.setAttribute(USER, user);
    }
}
