package db;

import org.aeonbits.owner.ConfigFactory;

public class BaseDB {

    private static MongoConfigProperties configuration;

    public BaseDB(){
        configuration = ConfigFactory.create(MongoConfigProperties.class);
    }

    public static MongoConfigProperties configuration(){
        return configuration;
    }

}
