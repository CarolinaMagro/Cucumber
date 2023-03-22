package db;

import java.util.Properties;

import db.Models.CelInactiveFeaturesModel;
import db.Models.TicklersModel;
import org.aeonbits.owner.ConfigFactory;
import org.hibernate.SessionFactory;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {
    private static SessionFactory sessionFactory;


    public HibernateUtil(){
        environment = ConfigFactory.create(pom.Environment.class);
    }

    private static pom.Environment environment;
    public static pom.Environment environment(){return environment;
    }


    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
               try {

                Configuration configuration = new Configuration();
                //Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings= new Properties();
                settings.put(Environment.DRIVER, "oracle.jdbc.OracleDriver");
                //settings.put(Environment.URL, "jdbc:oracle:thin:@bengolea.claro.amx:1521:ARDPROD");
                //settings.put(Environment.USER, "stl");
                //settings.put(Environment.PASS,"stl");
                settings.put(Environment.URL, environment().db_url());


                if (environment.db_user().isEmpty()){
                    settings.put(Environment.USER, System.getProperty("db_user"));
                }else {
                    settings.put(Environment.USER, environment.db_user());
                }
                if (environment.db_pass().isEmpty()){
                    settings.put(Environment.PASS, System.getProperty("db_pass"));
                }else {
                    settings.put(Environment.PASS, environment.db_pass());
                }


                settings.put(Environment.DIALECT,"org.hibernate.dialect.Oracle10gDialect");

                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO,"none");
                configuration.setProperties(settings);

                //Aqui las clases POJO
                configuration.addAnnotatedClass(CelInactiveFeaturesModel.class);
                configuration.addAnnotatedClass(TicklersModel.class);


                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                        applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return  sessionFactory;
    }




}
