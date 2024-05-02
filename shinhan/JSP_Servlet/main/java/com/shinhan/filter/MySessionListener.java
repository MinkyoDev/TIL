package com.shinhan.filter;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class MySessionListener implements HttpSessionListener {
	
    public MySessionListener() {
    	System.out.println("MySessionListener 생성됨");
    }

    public void sessionCreated(HttpSessionEvent se)  { 
    	System.out.println("MySessionListener ... sessionCreated");
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("MySessionListener 소멸됨");
    }
	
}
