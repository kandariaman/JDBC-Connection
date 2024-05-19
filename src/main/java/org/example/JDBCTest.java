package org.example;

import java.sql.*;

public class JDBCTest {

    public static void main(String[] args) throws SQLException {

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {

            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","student","qwerty1234");
            System.out.println("Database connection successful");

            myStmt = myConn.createStatement();

            myRs = myStmt.executeQuery("select * from employees");

            while(myRs.next()){
                System.out.println(myRs.getString("first_name"));
                System.out.println(myRs.getString("last_name"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
