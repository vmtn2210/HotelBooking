/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nguyenbk.listener;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import nguyenbk.utils.DBHelper;

/**
 *
 * @author buikh
 */
public class MyApplicationServletListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        
        try {
        DBHelper.getSiteMaps(context);
        } catch (IOException ex) {
            context.log("MyApplicationServletListener _ IO " + ex.getMessage());
        } 
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Undeploying ....");    
        ServletContext context = sce.getServletContext();
        
        context.removeAttribute("SITEMAPS");
    }
    
}
