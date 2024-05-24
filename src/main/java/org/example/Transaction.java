package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Transaction {

    public static void main(String[] args) throws Exception {

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {

            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","student","qwerty1234");
            System.out.println("Database connection successful");

            myConn.setAutoCommit(false);

            myStmt = myConn.createStatement();

            myStmt.executeUpdate(
                    "delete from employees where department='HR'");

            myRs = myStmt.executeQuery("select * from employees order by last_name");

            myStmt.executeUpdate("update employees set salary=30000 where department='Engineering'");

            boolean ok = askUserIfOkToSave();

            if(ok) {
                myConn.commit();
            } else {
                myConn.rollback();

            }

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

    private static boolean askUserIfOkToSave() {

        System.out.println("Is is ok to save");
        Scanner myObj = new Scanner(System.in);

        System.out.println("Enter name, age and salary:");

        // String input
        String okToSave = myObj.nextLine();

        return okToSave.equals("ok");

    }

}
