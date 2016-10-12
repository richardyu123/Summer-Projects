package com.company;

import java.sql.*;

public class Main {
/*
    public static void main(String[] args) {
	// write your code here
        Class.forName("org.postgresql.Driver");
        Connection conn = null;
        conn = DriverManager.getConnection(
                "jdbc:postgresql://hostname:port/dbname","username", "password");
        conn.close();
        String callableSQL = "{call upper(?)}";
        CallableStatement upperProc = conn.prepareCall("{ ? = call upper( ? ) }");
        upperProc.registerOutParameter(1, Types.VARCHAR);
        upperProc.setString(2, "lowercase to uppercase");
        upperProc.execute();
        String upperCased = upperProc.getString(1);
        upperProc.close();
        Connection dbConnection;
        try {
            dbConnection = getDBConnection();
            callableStatement = dbConnection.prepareCall(callableSQL);

            callableStatement.setString(1, "lowercase to uppercase");

            //register multiple output parameters to match all return values
            callableStatement.registerOutParameter(1, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(3, java.sql.Types.XYZ);  //any data type here

            callableStatement.execute();

            //do something with your return values
            String xyz = callableStatement.getString(1);
            //... for other items you have registered.

        } catch (SQLException up) {
            throw up;  //haha!
        } finally {
            //Silently close off
            if (callableStatement != null) {
                callableStatement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }*/
}
