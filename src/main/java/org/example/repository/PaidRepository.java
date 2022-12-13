package org.example.repository;

import org.example.DataBaseConnection.SingleTonConnection;
import org.example.entity.Paid;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PaidRepository extends RepositoryImpl<Paid,Long> {
    public static List<Paid> listPaid(Long id) {
        Session session = SingleTonConnection.getInstance().openSession();
        Transaction transaction = null;
        try {
            Query q = session.createQuery("select l from Paid l where l.daneshjo.id = :id");
            q.setParameter("id", id);
            List<Paid> list = q.list();
            return list;
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException();
        }finally {
            session.close();
        }
    }

}
