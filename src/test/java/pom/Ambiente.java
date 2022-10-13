package pom;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${environment}.properties"

})
public interface Ambiente extends Config {

    String urlIamLitleTester();

    String urlPantallaPrincipal();
    String urlCambioNim();

    String user();

    String pass();

    String titlePage();


   String mongo_database_user();
   String mongo_database_admin();
   String mongo_database_host();
   int mongo_database_port();

   String user_claro();



}