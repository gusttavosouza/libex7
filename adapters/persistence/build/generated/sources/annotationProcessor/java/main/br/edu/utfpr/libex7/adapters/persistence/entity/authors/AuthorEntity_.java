package br.edu.utfpr.libex7.adapters.persistence.entity.authors;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AuthorEntity.class)
public abstract class AuthorEntity_ {

	public static volatile SingularAttribute<AuthorEntity, String> name;
	public static volatile SingularAttribute<AuthorEntity, Long> id;

	public static final String NAME = "name";
	public static final String ID = "id";

}

