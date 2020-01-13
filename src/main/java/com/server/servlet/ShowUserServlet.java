package com.server.servlet;

import com.server.dao.UserDao;
import com.server.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/showuser")
public class ShowUserServlet extends HttpServlet {
    private UserDao userDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("id");
        if (userId == null){
            throw new ServletException("Missing parameter 'id'");
        }
        User user = userDao.getUserById(Integer.valueOf(userId));
        if (user == null){
            resp.setStatus(404);
            req.getRequestDispatcher("/notfound.jsp").forward(req,resp);
            return;
        }
        req.setAttribute("user", user);
        req.setAttribute("PageTitle", "Show user");
        req.setAttribute("PageBody", "showuser.jsp");
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }

    @Override
    public void init() throws ServletException {
        userDao = (UserDao) getServletContext().getAttribute("userDao");
        super.init();
    }
}
