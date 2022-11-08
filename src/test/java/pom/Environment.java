package pom;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${environment}.properties"

})
public interface Environment extends Config {

    String urlIamLitleTester();

    String urlPantallaPrincipal();
    String urlCambioNim();

    String user();

    String pass();

    String titlePage();


   String user_claro();

    String db_url();
    String db_user();
    String db_pass();

}