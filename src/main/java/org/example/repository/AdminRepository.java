package org.example.repository;

import org.example.DataBaseConnection.SingleTonConnection;
import org.example.entity.Daneshjo;
import org.example.entity.Loans;
import org.example.exception.UserNotFound;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class AdminRepository {

    //section login
    public static boolean login(Daneshjo daneshjo) throws UserNotFound {
        Transaction transaction = null;
        Session session = SingleTonConnection.getInstance().openSession();
        try {
            transaction = session.beginTransaction();
            final NativeQuery nativeQuery = session.createNativeQuery("select * from admin where username = ? and password = ?;");
            nativeQuery.setParameter(1, daneshjo.getUserName());
            nativeQuery.setParameter(2, daneshjo.getPassword());
            final Optional first = nativeQuery.getResultList().stream().findFirst();
            return first.isPresent();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            throw new UserNotFound();
        }
    }
    //section Daneshjo Loans
    public static List<Loans> daneshjoLoans(String str) {
        Session session = SingleTonConnection.getInstance().openSession();
        try {
//            Query q = session.createQuery("select l from Loans l where l.status = :str");
            Query q = session.createQuery("from Loans");
//            q.setParameter("str", str);
            List<Loans> list = q.list();
            return list;
        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            session.close();
        }
    }
}
