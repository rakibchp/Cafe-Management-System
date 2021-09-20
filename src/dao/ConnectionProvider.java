/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import static java.sql.DriverManager.getConnection;

/**
 *
 * @author Asus
 */
public class ConnectionProvider {
    
    public static Connection getCon(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = getConnection("jdbc:mysql://localhost:3306/cms?useSSL=false","root","123456");
            return con;
          
        }
        catch(Exception e){
            return null;
        }
    }
    
}
