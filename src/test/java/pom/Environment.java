package pom;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${environment}.properties"

})
public interface Environment extends Config {

    String user_login();
    String pass_login();
    String urlPantallaPrincipal();

}