package glue.ApiSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import db.JDBC.*;

import static db.Dao.InactiveCelsDao.*;
import static db.Dao.TicklersDao.QueryTickler;
import static db.Dao.TicklersDao.findTicklerById;
import static db.JDBC.ejecutarQuery;


public class Oracle {

    @Given("^Ingreso a la DB$")
    public void ingresoALaDB() throws Throwable {

        /* Class.forName("oracle.jdbc.OracleDriver");


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
        System.out.println(resultSet.toString());*/

        //findInactiveCel("0000002841");

        //System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
        //queryTest();
        //System.out.println(QuerySQL().toString());
        //System.out.println(QuerySQL());
        //findTicklerById("2429818337");

        //QueryTickler();
        ejecutarQuery("SELECT tck_id,"+
                "tck_acc_id,"+
                "tck_clu_cellular_number,"+
                "tck_ncl_identification_type,"+
                "tck_ncl_identification_number,"+
                "tck_opened_date,"+
                "tck_usr_id_made_by,"+
                "usr_surname2,"+
                "tck_act_id,"+
                "act_description,"+
                "tck_ar_rsn_id,"+
                "rsn_description,"+
                "tck_stt_id,"+
                "stt_description,"+
                "tck_priority,"+
                "tck_description,"+
                "tck_ugr_id,"+
                "ugr_description,"+
                "tck_usr_id,"+
                "usr_surname,"+
                "tck_follow_up_date,"+
                "tck_closed_date FROM view_ticklers WHERE tck_id = '7954199283'");

    }

    @Then("^deberia ver$")
    public void deberiaVer() throws Throwable {

    }



}
