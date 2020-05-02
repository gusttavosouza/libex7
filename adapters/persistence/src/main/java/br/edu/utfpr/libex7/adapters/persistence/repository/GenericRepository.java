package br.edu.utfpr.libex7.adapters.persistence.repository;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public abstract class GenericRepository<T, K> {

    protected Connection connection;

    public GenericRepository(Connection connection){
        this.connection = connection;
    }

    public abstract T save(T entity);

    public abstract Optional<T> findById(K id);

    public abstract List<T> findAll();

    public abstract void remove(K id);


}
