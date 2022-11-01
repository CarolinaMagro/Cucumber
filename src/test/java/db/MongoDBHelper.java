package db;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import org.bson.Document;
import utils.LogHelper;
import java.io.IOException;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MongoDBHelper extends BaseDB {


    private static final Logger LOGGER = LogHelper.getLogger(MongoDBHelper.class);
    private static MongoClient mongoClient;

    /**
     * Se conecta a un servidor y obtiene un cliente de Mongo
     */

    public static void connectToServer() throws IOException {
        LOGGER.log(Level.INFO, "Conectandose al servidor...");

        String user= configuration().mongo_database_user();
        String database = configuration().mongo_database_admin();

        MongoCredential credential = MongoCredential.createCredential(user, database,(configuration().password()).toCharArray());
        mongoClient = new MongoClient(new ServerAddress(configuration().mongo_database_host(),
                configuration().mongo_database_port()), Collections.singletonList(credential));

        try {
            mongoClient.getAddress();
            LOGGER.log(Level.INFO, "Conexion exitosa");

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "No se pudo conectar correctamente al servidor");
            LOGGER.log(Level.SEVERE, e.getMessage());
            mongoClient.close();
        }

    }

    /**
     * Obtener una base de datos
     *
     * @return una base de datos
     */
    public static MongoDatabase getDataBase(String dbName){
        return mongoClient.getDatabase(dbName);
    }

    /**
     * Obtener una coleccion
     *
     * @return una coleccion
     */
    public static MongoCollection<Document> getCollectionFromDb(MongoDatabase db, String collection){
        return db.getCollection(collection);
    }

    /**
     * Obtener una valor dado una clave de una coleccion
     *
     * @return un objeto
     */
    public static Document getDocumentBykeyValue(MongoCollection<Document> collection, String key, String value){
        return collection.find(Filters.eq(key,value)).first();
    }

    /**
     * Obtener un valor dado una clave de una coleccion
     *
     * @return un objeto
     */
    public static Object getElementByKeyFromDocument(Document document, String key){
        return document.get(key);
    }

}
