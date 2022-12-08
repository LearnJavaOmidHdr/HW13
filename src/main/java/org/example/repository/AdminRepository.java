package org.example.repository;

import org.example.DataBaseConnection.SingleTonConnection;
import org.example.entity.Daneshjo;
import org.example.exception.UserNotFound;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.Optional;

public class AdminRepository {

    public static boolean login(Daneshjo daneshjo) throws UserNotFound {
        Transaction transaction = null;
        Session session = SingleTonConnection.getInstance().openSession();
        try {
            transaction = session.beginTransaction();
            final NativeQuery nativeQuery = session.createNativeQuery("select * from admin where user_name = ? and password = ?;");
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
}
