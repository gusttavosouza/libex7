package br.edu.utfpr.libex7.adapters.persistence.mapper;

import java.util.LinkedList;
import java.util.List;

public abstract class GenericMapper<X,Y> {

    public abstract X mapToDomain(Y objEntity);

    public abstract Y mapToEntity(X objDomain);
    
    public List<X> mapToDomain(List<Y> entityList){
    	List<X> domainList = new LinkedList<>();
    	for(Y entity : entityList) {
    		X domain = mapToDomain(entity);
    		domainList.add(domain);
    	}
    	return domainList;
    }

    public List<Y> mapToEntity(List<X> domainList){
    	List<Y> entityList = new LinkedList<>();
    	for(X domain : domainList) {
    		Y entity = mapToEntity(domain);
    		entityList.add(entity);
    	}
    	return entityList;
    }
    
   
}
