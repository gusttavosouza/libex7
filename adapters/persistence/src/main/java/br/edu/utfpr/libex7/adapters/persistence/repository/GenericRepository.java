package br.edu.utfpr.libex7.adapters.persistence.repository;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.edu.utfpr.libex7.adapters.persistence.util.relection.ReflectionUtils;

public abstract class GenericRepository<T, K> {

    protected EntityManager em;

    public GenericRepository(EntityManager em){
		this.em = em;
    }

    public T save(T entity) {
    	em.getTransaction().begin();
    	if(isNew(entity)) {
    		em.persist(entity);
    	}else {
    		entity = em.merge(entity);
    	}
    	em.getTransaction().commit();
       return entity;
    }

    public Optional<T> findById(K id){
    	Class<T> classType = getClassType();
		return Optional.ofNullable(em.find(classType, id));
    }

    public List<T> findAll(){
       Class<T> classType = getClassType();
	   CriteriaBuilder cb = em.getCriteriaBuilder();
       CriteriaQuery<T> cq = cb.createQuery(classType);
       Root<T> root = cq.from(classType);
       cq.select(root);
       TypedQuery<T> query = em.createQuery(cq);
       return query.getResultList();
    	
    }

    public void remove(K id) {
    	Optional<T> optionalEntity = this.findById(id);
    	if(optionalEntity.isEmpty()) {
    		T entity = optionalEntity.get();
    		em.remove(entity);
    	}
    }
    
    protected boolean isNew(T entity) {
    	try {
    	Class<T> classType = getClassType();
    	List<Field> fields = ReflectionUtils.getFields(classType, Id.class);
    	Field field = fields.stream().findFirst().orElseThrow();
    	field.setAccessible(true);
    	Object id = field.get(entity);
    	return !(id != null
    	        && !em.contains(entity) 
    	        && em.find(classType, id) != null);  
    	}catch(Exception e) {
    		throw new RuntimeException(e);
    	}
    }
    
    @SuppressWarnings("unchecked")
	protected Class<T> getClassType(){
    	final ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<T>) (type).getActualTypeArguments()[0];
    }


}
