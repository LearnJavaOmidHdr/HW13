package org.example.repository.BaseRipo;

import lombok.var;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;


public class BaseRipoImpl<T, ID> implements BaseRepo<T, ID> {

    @Override
    public void save(T t) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(t);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    @Override
    public void update(T t) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(t);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();

        }

    }

    @Override
    public void delete(T t) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(t);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

    }

    @Override
    public void deleteById(ID id) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    @Override
    public T findById(Class<T> tClass, ID id) {
        try (var session = getSessionFactory().openSession()) {
            return session.get(tClass, (String) id);
        }
    }

    @Override
    public List<T> findAll(Class<T> tClass) {
        try (var session = getSessionFactory().openSession()) {
            var criteriaBuilder = session.getCriteriaBuilder();
            var criteriaQuery = criteriaBuilder.createQuery(tClass);
            var root = criteriaQuery.from(tClass);
            return session.createQuery(criteriaQuery.select(root)).list();
        }
    }
}