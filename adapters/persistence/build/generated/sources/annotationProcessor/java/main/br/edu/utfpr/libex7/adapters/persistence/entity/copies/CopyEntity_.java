package br.edu.utfpr.libex7.adapters.persistence.entity.copies;

import br.edu.utfpr.libex7.adapters.persistence.entity.books.BookEntity;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CopyEntity.class)
public abstract class CopyEntity_ {

	public static volatile SingularAttribute<CopyEntity, LocalDate> acquisitionDate;
	public static volatile SingularAttribute<CopyEntity, BookEntity> book;
	public static volatile SingularAttribute<CopyEntity, Long> id;
	public static volatile SingularAttribute<CopyEntity, StatusCopyDataEnum> status;

	public static final String ACQUISITION_DATE = "acquisitionDate";
	public static final String BOOK = "book";
	public static final String ID = "id";
	public static final String STATUS = "status";

}

