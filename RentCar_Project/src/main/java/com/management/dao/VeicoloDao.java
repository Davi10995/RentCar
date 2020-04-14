package com.management.dao;

import com.management.model.User;
import com.management.util.HibernateUtil;
import com.management.model.Veicolo;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.transaction.Transactional;

@Transactional
public class VeicoloDao {


    public void saveVeicolo(Veicolo veicolo) {
        Transaction transaction = null;
        try (Session session = openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(veicolo);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Update Veicolo
     * @param veicolo
     */
    public void updateVehicle(Veicolo veicolo) {
        Transaction transaction = null;
        try (Session session = openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(veicolo);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Delete Veicolo
     * @param id
     */
    public void deleteVehicle(int id) {

        Transaction transaction = null;
        try (Session session = openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a user object
            Veicolo veicolo = session.get(Veicolo.class, id);
            if (veicolo != null) {
                session.delete(veicolo);
                System.out.println("user is deleted");
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Veicolo getVeicoloById(int id) {

        Transaction transaction = null;
        List < Veicolo > veicoli = null;
        try (Session session = openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            Query query = session.createQuery("from Veicolo u where u.id = :id");
            query.setParameter("id", id);
            veicoli = query.list();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return veicoli.get(0);
    }

    /**
     * Get all Veicoli
     * @return
     */
    @SuppressWarnings("unchecked")
    public List < Veicolo > getAllVeicoli() {

        Transaction transaction = null;
        List < Veicolo > veicoli = null;
        try (Session session = openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            veicoli = session.createQuery("from Veicolo ").getResultList();
            //commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return veicoli;
    }


    private Session openSession(){
        return HibernateUtil.getSessionFactory().openSession();
    }

}