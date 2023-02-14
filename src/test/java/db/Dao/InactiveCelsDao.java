package db.Dao;

import cucumber.api.java.gl.E;
import db.Models.CelInactiveFeaturesModel;
import db.HibernateUtil;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.sql.PreparedStatement;
import java.util.List;

public class InactiveCelsDao {

    public void saveCelInative(CelInactiveFeaturesModel cel) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            //start the transaction
            session.getTransaction();

            //save student object
            session.save(cel);

            //commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }


    public void deleteInactiveCel(CelInactiveFeaturesModel cel) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            //start the transaction
            session.getTransaction();

            //save student object
            session.remove(cel);

            //commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }


    public void editInactiveCel(CelInactiveFeaturesModel cel) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            //start the transaction
            session.getTransaction();

            //save student object
            session.save(session.merge(cel));

            //commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }


    public static void findInactiveCel(String primaryKey ) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            //start the transaction
            session.getTransaction();

            CelInactiveFeaturesModel cel = session.find(CelInactiveFeaturesModel.class, primaryKey);


            System.out.println(cel.getPif_ftr_id());
            System.out.println(cel.getPif_clu_cellular_number());
            System.out.println(cel.getPif_start_date());
            System.out.println(cel.getPif_end_date());

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se encontraron resultados para :"+ primaryKey);
        }

    }


    public static void queryTest() {
        String jpql = "FROM CelInactiveFeaturesModel c WHERE c.pif_ftr_id = '90'";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            //start the transaction
            session.getTransaction();

            Query query = session.createQuery(jpql);
            List<CelInactiveFeaturesModel> listInactiveCels=query.getResultList();

            for (CelInactiveFeaturesModel inactiveCells: listInactiveCels){
                System.out.println(inactiveCells.getPif_ftr_id());
                System.out.println(inactiveCells.getPif_clu_cellular_number());
                System.out.println(inactiveCells.getPif_start_date());
                System.out.println(inactiveCells.getPif_end_date());
            }

            session.close();

        } catch (Exception e) {
            System.out.println("Falló!!!!");
            e.printStackTrace();
        }
    }

    public static Object QuerySQL(){
        Object rows = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            //start the transaction
            session.getTransaction();
            Query query = session.createSQLQuery("select tck.TCK_ID from TICKLERS as tck WHERE TCK_ID='194292078'");
            rows = query.getFirstResult();

        }catch (Exception e){
            System.out.println("Algo salio mal");
        }
        return rows;
    }


    public static void QueryExample() {
        NativeQuery miQuery = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            //start the transaction
            session.getTransaction();
            miQuery = session.createNativeQuery("select * from TICKLERS WHERE TCK_ID='194292078'");
        } catch (Exception e) {
        }
        miQuery.getResultList();

    }




}