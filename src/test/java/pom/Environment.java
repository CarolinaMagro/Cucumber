package pom;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${environment}.properties"

})
public interface Environment extends Config {

    String user_login();

    String pass_login();

    String urlPantallaPrincipal();
    String urlCambioNim();

    String titlePage();



    String db_url();
    String db_user();
    String db_pass();

}