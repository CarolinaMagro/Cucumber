package glue.dummy;



import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.*;

public class demo {
    //Connection object
    static Connection connection;
    //Statement object
    private static Statement statement;
    //Constant for DB URL
    //public static String DB_URL = "jdbc:sqlserver://58.2.92.60:1433/RBL_Feb2016";
    public static String DB_URL = "melideo.claro.amx";
    //DB credential
    public static String userName = "DESA_CUSTOMER";
    public static String password = "xnfUUqlNay";



    @Test
    public void test() throws SQLException {
        try {
            System.out.println("Before");
            //Make the DB Connection
            //String DBClass = "oracle.jdbc.OracleDriver";
            String DBClass = "jdbc:oracle:thin:@melideo.claro.amx:1521:ARTPROD";
            //String DBClass ="jdbc:oracle:thin:@bengolea.claro.amx:1521:ARDPROD";
            Class.forName(DBClass).newInstance();
            //Get Connection DB
            Connection connection =  DriverManager.getConnection(DB_URL, userName, password);
            //Statement object to send the SQL statement to DB
            statement = connection.createStatement();

        }catch(Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Executing Test");
            String query = "select * from TICKLERS";
            //Get the content of customer table from DB
            ResultSet resultSet = statement.executeQuery(query);
            //Print the result until all the records are printed
            while(resultSet.next()) {
                System.out.println(resultSet.getString(1));
                System.out.println("\t" + resultSet.getString(2));
            }

        }catch(Exception ee) {
            ee.printStackTrace();
        }
        System.out.println("After");
        //CLose DB Connection
        if(connection != null) {
            connection.close();
        }

    }



}