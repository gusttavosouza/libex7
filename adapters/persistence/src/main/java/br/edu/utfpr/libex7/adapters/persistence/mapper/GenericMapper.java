package br.edu.utfpr.libex7.adapters.persistence.mapper;

public interface GenericMapper<X,Y> {

    X mapToDomain(Y objEntity);

    Y mapToEntity(X objDomain);
}
