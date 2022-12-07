package org.example.repository;

import lombok.val;
import org.example.DataBaseConnection.SingleTonConnection;

import java.io.Serializable;
import java.util.List;

public class RepositoryImpl<E, ID extends Serializable> implements BaseRepository<E, ID> {

    @Override
    public Object create(E e) {
        try (val session = SingleTonConnection.getInstance().openSession()) {
            val transaction = session.beginTransaction();
            try {
                Object save = session.save(e);
                transaction.commit();
                return save;
            } catch (Exception exception) {
                exception.printStackTrace();
                transaction.rollback();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(E e) {
        try (val session = SingleTonConnection.getInstance().openSession()) {
            val transaction = session.beginTransaction();
            try {
                session.delete(e);
                transaction.commit();
            } catch (Exception exception) {
                exception.printStackTrace();
                transaction.rollback();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(E e) {
        try (val session = SingleTonConnection.getInstance().openSession()) {
            val transaction = session.beginTransaction();
            try {
                session.update(e);
                transaction.commit();
            } catch (Exception exception) {
                exception.printStackTrace();
                transaction.rollback();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public List<E> findAll(Class<E> eClass) {
        try (val session = SingleTonConnection.getInstance().openSession()) {
            val transaction = session.beginTransaction();
            return session.createQuery("FROM " + eClass.getName()).getResultList();
        } catch (Exception exeException) {
            exeException.printStackTrace();
        }
        return null;
    }

    @Override
    public E findById(ID id, Class<E> eClass) {
        try (val session = SingleTonConnection.getInstance().openSession()) {
            val transaction = session.beginTransaction();
            return session.get(eClass, id);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }


}
