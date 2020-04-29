package br.edu.utfpr.libex7.adapters.persistence.repository;

import java.sql.Connection;
import java.util.List;

public abstract class GenericRepository<T, K> {

    protected Connection connection;

    public GenericRepository(Connection connection){
        this.connection = connection;
    }

    protected abstract T save(T entity);

    protected abstract T findById(K id);

    protected abstract List<T> findAll();


}
