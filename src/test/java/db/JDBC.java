package db;


import org.aeonbits.owner.ConfigFactory;

import java.sql.*;

// Main class
public class JDBC {
    private static pom.Environment environment;
    public static pom.Environment environment(){
        return environment;
    }

    public JDBC(){
        environment = ConfigFactory.create(pom.Environment.class);
    }


        static Connection con = null;



    public static ResultSet ejecutarQuery(String query) {
         String url= environment().db_url();
         String user = System.getProperty("db_user");
         String pass = System.getProperty("db_pass");


        ResultSet resultSet = null;
        try {


            // Registering drivers
            DriverManager.registerDriver(
                    new oracle.jdbc.OracleDriver());

            // Reference to connection interface
            con = DriverManager.getConnection(url, user,
                    pass);

            // Creating a statement
            Statement st = con.createStatement();

            // Executing query
            resultSet = st.executeQuery(query);
            while(resultSet.next()){

                System.out.println(resultSet.getString("TCK_ID"));
               }
            con.close();
        }

        catch (Exception ex) {
            System.err.println(ex);
        }
        return resultSet;
    }

}
