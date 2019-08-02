package com.jnshu.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class countsession implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("HttpSession被建立");
        ServletContext application=arg0.getSession().getServletContext();
        Integer count = (Integer)application.getAttribute("count");
        if(count==null){
            count=1;
            application.setAttribute("count", count);
        }else{
            count++;
            application.setAttribute("count", count);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("HttpSession被销毁");
        ServletContext application=arg0.getSession().getServletContext();
        Integer count = (Integer)application.getAttribute("count");
        count--;
        application.setAttribute("count", count);
    }
}
