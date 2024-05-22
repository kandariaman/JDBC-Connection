package org.example;

import java.sql.*;

public class CallingStoredProcedures {

    public static void main(String[] args) throws Exception {

        Connection myConn = null;
        CallableStatement myStmt = null;
        ResultSet myRs = null;

        try {

            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","student","qwerty1234");
            System.out.println("Database connection successful");

            String theDepartment = "Engineering";
            int theIncreaseAmount = 10000;

            myStmt = myConn.prepareCall("{call increase_salaries_for_department(?, ?)}");

            myStmt.setString(1, theDepartment);
            myStmt.setDouble(2, theIncreaseAmount);

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
