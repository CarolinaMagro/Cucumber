package db.DbConfig;

import java.util.Properties;

import org.hibernate.SessionFactory;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
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

                settings.put(Environment.URL, "jdbc:oracle:thin:@melideo.claro.amx:1521:ARTPROD");
                settings.put(Environment.USER, "DESA_CUSTOMER");
                settings.put(Environment.PASS,"xnfUUqlNay");

                settings.put(Environment.DIALECT,"org.hibernate.dialect.Oracle10gDialect");

                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO,"none");
                configuration.setProperties(settings);

                //Aqui las clases POJO
                configuration.addAnnotatedClass(CelInactiveFeaturesModel.class);

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
