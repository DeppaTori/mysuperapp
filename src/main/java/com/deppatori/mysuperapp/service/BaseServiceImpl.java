package com.deppatori.mysuperapp.service;

import com.deppatori.mysuperapp.model.BaseModel;
import com.deppatori.mysuperapp.repository.BaseRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class BaseServiceImpl<T extends BaseModel> implements BaseService<T> {

    @Autowired
    private BaseRepository<T,String>  repository;

    @Override
    public Set<T> findAll() {
        return new HashSet(repository.findAll());
    }

    @Override
    public T findOne(ObjectId _id) {
        return repository.findBy_id(_id);
    }

    @Override
    public T save(T t) {
        return repository.save(t);
    }

    @Override
    public T update(ObjectId _id, T t) {
        BaseModel bm = repository.findBy_id(_id);
        if(bm != null){
            t.set_id(_id);
            return repository.save(t);
        }
        return null;
    }

    @Override
    public void delete(ObjectId _id) {
        repository.deleteById(_id.toHexString());
    }
}
