package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class deleteData {

    public static void main(String[] args) throws Exception {

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {

            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","student","qwerty1234");
            System.out.println("Database connection successful");

            myStmt = myConn.createStatement();

            myStmt.executeUpdate(
                    "delete from employees " +
                            "where last_name='Doe' and first_name='John'");

            myRs = myStmt.executeQuery("select * from employees order by last_name");

            while(myRs.next()){
                System.out.println(myRs.getString("email") + ", " + myRs.getString("first_name"));
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
