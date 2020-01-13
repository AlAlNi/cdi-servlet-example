package com.server.servlet;

import com.server.dao.MobileDao;
import com.server.pojo.Mobile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editmobile")
public class EditMobileServlet extends HttpServlet {
    private MobileDao mobileDao;

    @Override
    public void init() throws ServletException {
        mobileDao = (MobileDao) getServletContext().getAttribute("dao");
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("id");
        if (userId == null){
            throw new ServletException("Missing parameter 'id'");
        }
        Mobile mobile = mobileDao.getMobileById(Integer.valueOf(userId));
        if (mobile == null){
            resp.setStatus(404);
            req.getRequestDispatcher("/notfound.jsp").forward(req,resp);
            return;
        }
        req.setAttribute("mobile", mobile);
        req.setAttribute("PageTitle", "Edit Mobile");
        req.setAttribute("PageBody", "editMobileForm.jsp");
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        String model = req.getParameter("model");
        String price = req.getParameter("price");
        String manufacturer = req.getParameter("manufacturer");
        mobileDao.updateMobileById(new Mobile(Integer.parseInt(id), model, Integer.valueOf(price), manufacturer));
        resp.sendRedirect(req.getContextPath() + "/allmobiles");
    }
}
