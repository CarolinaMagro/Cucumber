package db.Dao;

import db.HibernateUtil;
import db.Models.CelInactiveFeaturesModel;
import db.Models.TicklersModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import javax.persistence.Column;
import java.util.List;

public class TicklersDao {








    public static void findTicklerById(String id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            //start the transaction
            session.getTransaction();

            TicklersModel tickler = session.find(TicklersModel.class, id);

                System.out.println(tickler.getTck_id());
                System.out.println(tickler.getTck_opened_date());
                System.out.println(tickler.getTck_closed_date());
                System.out.println(tickler.getTck_description());
                System.out.println(tickler.getTck_follow_up_date());
                System.out.println(tickler.getTck_priority());
                System.out.println(tickler.getTck_usr_id());
                System.out.println(tickler.getTck_ar_rsn_id());
                System.out.println(tickler.getTck_ar_act_id());
                System.out.println(tickler.getTck_stt_id());
                System.out.println(tickler.getTck_usr_id_made_by());
                System.out.println(tickler.getTck_tck_id());
                System.out.println(tickler.getTck_ugr_id());
                System.out.println(tickler.getTck_acc_id());
                System.out.println(tickler.getTck_act_id());
                System.out.println(tickler.getTck_clu_cellular_number());
                System.out.println(tickler.getTck_mail_flag());
                System.out.println(tickler.getTck_last_updated_date());
                System.out.println(tickler.getTck_ticket_number());
                //System.out.println(tickler.getTck_ncl_identification_type());
                //System.out.println(tickler.getTck_ncl_identification_number());
                //System.out.println(tickler.getTck_process_date());
                //System.out.println(tickler.getTck_input_date());
                //System.out.println(tickler.getTck_ncl_id());
                //System.out.println(tickler.getTck_aud_date());
            session.close();

        } catch (Exception e) {
            System.out.println("Falló!!!!");
            e.printStackTrace();
        }
    }




    public static void QueryTickler(){
        String rows = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            //start the transaction
            session.getTransaction();



            Query query = session.createSQLQuery("SELECT t.tck_id FROM ticklers t WHERE rownum <= 10 ORDER BY tck_id");
            rows = query.getResultList().toString();
            System.out.println("IDs Query:"+rows);
        }catch (Exception e){
            System.out.println("Algo salio mal");
        }
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