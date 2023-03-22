package com.example.bootdemo.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Component
public class MyHTTPSessionListener implements HttpSessionListener {
    private static final Logger logger = LoggerFactory.getLogger(MyHTTPSessionListener.class);
    public Integer guestCount = 0;

    @Override
    public synchronized void sessionCreated(HttpSessionEvent se) {
        logger.info("new guest been online");
        guestCount++;
        logger.info("current #guest:{}", guestCount);
        se.getSession().getServletContext().setAttribute("guestCount:", guestCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        logger.info("new guest been offline");
        guestCount--;
        se.getSession().getServletContext().setAttribute("guestCount:", guestCount);
    }
}
