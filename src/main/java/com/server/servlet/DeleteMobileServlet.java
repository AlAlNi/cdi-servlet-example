package com.server.servlet;

import com.server.dao.MobileDao;
import com.server.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletemobile")
public class DeleteMobileServlet extends HttpServlet {
    private MobileDao mobileDao;

    @Override
    public void init() throws ServletException {
        mobileDao = (MobileDao) getServletContext().getAttribute("dao");
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mobileId = req.getParameter("id");
        if (mobileId == null){
            throw new ServletException("Missing parameter 'id'");
        }
        mobileDao.deleteMobileById(Integer.parseInt(mobileId));
        resp.sendRedirect(req.getContextPath() + "/allmobiles");
    }
}
