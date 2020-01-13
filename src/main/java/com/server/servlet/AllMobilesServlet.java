package com.server.servlet;

import com.server.dao.MobileDao;
import com.server.pojo.Mobile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet(urlPatterns = "/allmobiles", name = "Mobiles")
public class AllMobilesServlet extends HttpServlet {
    private MobileDao mobileDao;
    private Logger log = LoggerFactory.getLogger(AllMobilesServlet.class);

    @Override
    public void init() throws ServletException {
        mobileDao = (MobileDao) getServletContext().getAttribute("dao");
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<Mobile> mobiles = mobileDao.getAllMobile();
        log.info(mobiles.toString());
        req.setAttribute("mobiles", mobiles);
        req.setAttribute("PageTitle", "Mobiles");
        req.setAttribute("PageBody", "allmobiles.jsp");
        req.setAttribute("Redirect",  "/allmobiles");
        req.getRequestDispatcher("/index.jsp")
                .forward(req, resp);
    }
}