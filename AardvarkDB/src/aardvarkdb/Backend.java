/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aardvarkdb;

import java.sql.*;

public class Backend 
{
    private Connection con = null;
    
    public Backend()
    {
        try
        {
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/?user=root", "root", 
                "carson2k");
            Statement s = con.createStatement();
            s.executeQuery("use phase1");
        }
        catch(Exception e)
        {
            System.out.println("Could not establish connection");
        }
    }
    public ResultSet handleQuery(String query)
    {
        try
        {
            PreparedStatement p = con.prepareStatement(query);
            return p.executeQuery();
        }
        catch(Exception e)
        {
            System.out.println("Could not handle query");
            return null;
        }
    }
}