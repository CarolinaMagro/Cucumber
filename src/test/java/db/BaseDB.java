package db;

import org.aeonbits.owner.ConfigFactory;

public class BaseDB {

    private static ConfigProperties configuration;

    public BaseDB(){
        configuration = ConfigFactory.create(ConfigProperties.class);
    }

    public static ConfigProperties configuration(){
        return configuration;
    }

}
