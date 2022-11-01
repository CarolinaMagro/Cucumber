package glue.ApiSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Oracle {

    @Given("^Ingreso a la DB$")
    public void ingresoALaDB() throws Throwable {

        Class.forName("oracle.jdbc.OracleDriver");


        String url="jdbc:oracle:thin:@bengolea.claro.amx:1521:ARDPROD";
        String username="stl";
        String password="stl";

        //Connection connection = DriverManager.getConnection(url, username,password);
        //String dbURL = "jdbc:oracle:thin:tiger/scott@localhost:1521:productDB";
        Connection conn = DriverManager.getConnection(url,username,password);
        if (conn != null) {
            System.out.println("Connected");
        }

        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM cel_inactive_features");
        conn.close();
        System.out.println(resultSet.toString());


    }

    @Then("^deberia ver$")
    public void deberiaVer() throws Throwable {

    }



}
