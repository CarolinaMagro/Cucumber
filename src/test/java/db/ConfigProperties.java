package db;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config.properties"

})
public interface ConfigProperties extends Config {

   String mongo_database_user();

   String mongo_database_admin();

   String mongo_database_host();

   int mongo_database_port();

   String password();
}