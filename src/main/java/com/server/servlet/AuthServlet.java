package com.server.servlet;

import com.server.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("PageTitle", "Authenticate");
        req.setAttribute("PageBody", "auth.jsp");
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("login");
        String password = req.getParameter("password");
        if (name != null) CookieUtils.setLogin(resp, name);
        if (password != null) CookieUtils.setPassword(resp, password);
        resp.sendRedirect(req.getContextPath() + CookieUtils.getRedirect(req));
    }
}
