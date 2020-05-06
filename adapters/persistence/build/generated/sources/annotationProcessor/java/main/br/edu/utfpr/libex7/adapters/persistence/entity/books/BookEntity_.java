package br.edu.utfpr.libex7.adapters.persistence.entity.books;

import br.edu.utfpr.libex7.adapters.persistence.entity.authors.AuthorEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.categories.CategoryEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.copies.CopyEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BookEntity.class)
public abstract class BookEntity_ {

	public static volatile ListAttribute<BookEntity, CopyEntity> copies;
	public static volatile SingularAttribute<BookEntity, Integer> year;
	public static volatile SingularAttribute<BookEntity, Long> id;
	public static volatile SingularAttribute<BookEntity, String> title;
	public static volatile SingularAttribute<BookEntity, CategoryEntity> category;
	public static volatile ListAttribute<BookEntity, AuthorEntity> authors;

	public static final String COPIES = "copies";
	public static final String YEAR = "year";
	public static final String ID = "id";
	public static final String TITLE = "title";
	public static final String CATEGORY = "category";
	public static final String AUTHORS = "authors";

}

