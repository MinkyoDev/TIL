package com.shinhan.filter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class MyServletListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("ServletContextListener 소멸");
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("ServletContextListener 초기화");
    }
	
}
