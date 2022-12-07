package org.example.repository;


import java.util.List;

public interface BaseRepository<E,ID> {

    Object create(E e);

    void delete(E e);

    void update(E e);

    List<E> findAll(Class<E> eClass);

    E findById(ID id, Class<E> eClass);

}
