package com.server.servlet;

import com.server.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/allusers", name = "Users")
public class AllUsersServlet extends HttpServlet {
    private UserDao userDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", userDao.getAllUsers());
        req.setAttribute("PageTitle", "Users");
        req.setAttribute("PageBody", "allusers.jsp");
        req.setAttribute("Redirect",  "/allusers");
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    public void init() throws ServletException {
        userDao = (UserDao) getServletContext().getAttribute("userDao");
        super.init();
    }
}
