package Bank.Management.System;

import java.sql.*;

public class JDBCconnection {
    Connection con;
    Statement statement;
    public JDBCconnection(){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagement","root","Mysql@2003");
            statement = con.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
