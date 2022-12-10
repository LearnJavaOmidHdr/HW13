package org.example.repository;

import org.example.DataBaseConnection.SingleTonConnection;
import org.example.entity.Daneshjo;
import org.example.exception.UserNotFound;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class DaneshjoRepository extends RepositoryImpl<Daneshjo, Long> implements IdaneshjoiRepository {

    @Override
    public long login(Daneshjo daneshjo) throws UserNotFound {
        Transaction transaction = null;
        Session session = SingleTonConnection.getInstance().openSession();
//        try (val session = SingleTonConnection.getInstance().openSession()) {
        try {
            transaction = session.beginTransaction();
            final NativeQuery nativeQuery = session.createNativeQuery("select * from daneshjo where user_name = ? and password = ?;");
            nativeQuery.setParameter(1, daneshjo.getUserName());
            nativeQuery.setParameter(2, daneshjo.getPassword());
            List<Object[]> rows = nativeQuery.list();
            for(Object[] row : rows){
                daneshjo.setId(Long.parseLong(row[0].toString()));
            }
            final Optional first = nativeQuery.getResultList().stream().findFirst();
            if (first.isPresent()) return daneshjo.getId();
            return 0;
//            old way
//            final Optional first = nativeQuery.getResultList().stream().findFirst();
//            final Object singleResult = nativeQuery.getSingleResult();
//            return singleResult != null;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            throw new UserNotFound();
        }finally {
            session.close();
        }
    }

    public static boolean existInternational(String string) {
        Session session = SingleTonConnection.getInstance().openSession();
        Transaction transaction = null;
        try {
            session.beginTransaction();
            final NativeQuery nativeQuery = session.createNativeQuery("select * from loans where wifeinternational = ?;");
            nativeQuery.setParameter(1,string);
            final List list = nativeQuery.list();
            return list.size() > 0 ;

        }catch (Exception e) {
            transaction.rollback();
            throw new UserNotFound();
        }finally {
            session.close();
        }
    }

    public String getStatus(Long id) {
        Session session = SingleTonConnection.getInstance().openSession();
        Transaction transaction = null;
        try {
            session.beginTransaction();
            final Query<Daneshjo> query = session.createQuery("FROM Daneshjo WHERE id=:id", Daneshjo.class);
            query.setParameter("id",id);
            final Daneshjo daneshjo = query.uniqueResult();
            return daneshjo.getStatusDaneshjo().toString();
        }catch (Exception e) {
            transaction.rollback();
            throw new UserNotFound();
        }finally {
            session.close();
        }

    }
}