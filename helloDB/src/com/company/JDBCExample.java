package com.company;

import java.sql.*;

public class JDBCExample {

    public static void main(String[] argv) {

        System.out.println("-------- PostgreSQL "
                + "JDBC Connection Testing ------------");

        try {

            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your PostgreSQL JDBC Driver? "
                    + "Include in your library path!");
            e.printStackTrace();
            return;

        }

        System.out.println("PostgreSQL JDBC Driver Registered!");

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/Users_v2", "postgres",
                    "postgres");
            Statement stmt = connection.createStatement();
            stmt.execute("CREATE OR REPLACE FUNCTION refcursorfunc() RETURNS refcursor AS '"
                    + " DECLARE "
                    + "    mycurs refcursor; "
                    + " BEGIN "
                    + "    OPEN mycurs FOR SELECT username FROM users; "
                    + "    RETURN mycurs; "
                    + " END;' language plpgsql");
            stmt.close();

// We must be inside a transaction for cursors to work.
            connection.setAutoCommit(false);

// Procedure call.
            CallableStatement proc = connection.prepareCall("{ ? = call refcursorfunc() }");
            proc.registerOutParameter(1, Types.OTHER);
            proc.execute();
            ResultSet results = (ResultSet) proc.getObject(1);
            while (results.next()) {
                // do something with the results...
            }
            results.close();
            proc.close();

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;

        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }

    }


}