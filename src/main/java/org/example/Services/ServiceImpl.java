package org.example.Services;

import org.example.repository.BaseRepository;
import java.util.List;

public class ServiceImpl<R extends BaseRepository<E,ID>, E, ID> implements BaseService<E, ID> {

    private R r;

    public ServiceImpl(R r) {
        this.r = r;
    }

    @Override
    public Object create(E e) {
        return r.create(e);
    }

    @Override
    public void delete(E e) {
        r.delete(e);
    }

    @Override
    public void update(E e) {
        r.update(e);
    }

    @Override
    public List<E> findAll(Class<E> eClass) {
        return r.findAll(eClass);
    }

    @Override
    public E findById(ID id, Class<E> eClass) {
        return r.findById(id,eClass);
    }

}
