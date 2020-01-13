package com.server.servlet;

import com.server.dao.MobileDao;
import com.server.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {
    private Logger logger = LoggerFactory.getLogger(AppContextListener.class);
    @Inject
    private MobileDao mobileDao;

    @Inject
    private UserDao userDao;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("dao", mobileDao);
        servletContext.setAttribute("userDao", userDao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        servletContext.removeAttribute("dao");
        servletContext.removeAttribute("userDao");
        logger.info("Removed attribute DAO");
    }
}