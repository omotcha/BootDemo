package com.example.bootdemo.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

@Component
public class MyServletRequestListener implements ServletRequestListener {
    private static final Logger logger = LoggerFactory.getLogger(MyServletRequestListener.class);

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        logger.info("request ended");
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        logger.info("saved name: "+request.getAttribute("name"));
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        logger.info("SessionID: "+request.getRequestedSessionId());
        logger.info("uri: "+request.getRequestURI());
        request.setAttribute("name", "omotcha");
    }
}
