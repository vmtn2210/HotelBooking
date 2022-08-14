/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nguyenbk.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.sql.DataSource;

/**
 *
 * @author buikh
 */
public class DBHelper {
    
    public static Connection makeConnection()
            throws NamingException, SQLException /*ClassNotFoundException*/{
        Context context = new InitialContext();
        Context tomcatContext = (Context)context.lookup("java:comp/env");
        DataSource ds = (DataSource)tomcatContext.lookup("SE1614D5");
        Connection con = ds.getConnection();
        return con;

/*            //1. Load Driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //2. Create Connection String
            String url = "jdbc:sqlserver://"
                    + "localhost:1433"
                    + ";databaseName=NguyenSever";
            //3. Open Connection
            Connection con = DriverManager.getConnection(url, "sa", "khoinguyen712");

            return con;
*/
    }
    
    public static void getSiteMaps(ServletContext context) 
            throws IOException {
        //get properties
        String filePath = context.getInitParameter("SITE_MAPS_FILE_PATH");
        //convert properties file into input Stream
        InputStream is = null;
        
        is = context.getResourceAsStream(filePath);
        //create Properties object and load data
        Properties siteMaps = new Properties();
        siteMaps.load(is);
        // store in context scope
        context.setAttribute("SITEMAPS", siteMaps);
    }
}
