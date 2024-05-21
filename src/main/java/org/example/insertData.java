package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class insertData {

    public static void main(String[] args) throws Exception {

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {

            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","student","qwerty1234");
            System.out.println("Database connection successful");

            myStmt = myConn.createStatement();

            myStmt.executeUpdate(
                    "insert into employees " +
                    "(last_name, first_name, email, department, salary) " +
                    "values " +
                    "('johnson', 'eric', 'eric.johnson@gmail.com', 'HR', 40000.0)");

            myRs = myStmt.executeQuery("select * from employees order by last_name");

            while(myRs.next()){
                System.out.println(myRs.getString("last_name") + ", " + myRs.getString("first_name"));
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        finally {
            if(myRs != null) {
                myRs.close();
            }
        }
    }
}
