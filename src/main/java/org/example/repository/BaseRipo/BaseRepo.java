package org.example.repository.BaseRipo;

import org.example.DataBaseConnection.SingleTonConnection;
import org.hibernate.SessionFactory;

import java.util.List;

public interface BaseRepo<T,ID> {

    default SessionFactory getSessionFactory(){
        return SingleTonConnection.getInstance();
    }
    void save(T t);
    void update(T t);
    void delete(T t);
    void deleteById(ID id);
    T findById(Class<T> tClass, ID id);
    List<T> findAll(Class<T> tClass);

}
