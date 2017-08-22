package com.bing.unmannedVehicle.listener;


import com.bing.unmannedVehicle.rest.services.AbcServiceFactory;
import com.bing.unmannedVehicle.rest.services.XyzServiceFactory;
import nam.e.spa.ce.Xyz;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by bingzhang on 8/19/17.
 */
public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        AbcServiceFactory.createInstance();
        XyzServiceFactory.createInstance();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}

