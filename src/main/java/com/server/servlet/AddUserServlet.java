package com.server.servlet;

import com.server.dao.UserDao;
import com.server.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adduser")
public class AddUserServlet extends HttpServlet {
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        userDao = (UserDao) getServletContext().getAttribute("userDao");
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("PageTitle", "New User");
        req.setAttribute("PageBody", "addUserForm.jsp");
        req.setAttribute("Redirect",  "/adduser");
        req.getRequestDispatcher("/index.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        userDao.addUser(new User(null, name, Integer.valueOf(age), email, Long.valueOf(phone)));
        resp.sendRedirect(req.getContextPath() + "/allusers");
    }
}
