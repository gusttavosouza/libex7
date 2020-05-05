package br.edu.utfpr.libex7.adapters.persistence.entity.checkouts;

import br.edu.utfpr.libex7.adapters.persistence.entity.checkouts.CheckOutEntity.CheckInEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.checkouts.CheckOutEntity.CheckOutEntityId;
import br.edu.utfpr.libex7.adapters.persistence.entity.copies.CopyEntity;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CheckOutEntity.class)
public abstract class CheckOutEntity_ {

	public static volatile SingularAttribute<CheckOutEntity, CheckInEntity> checkIn;
	public static volatile ListAttribute<CheckOutEntity, CopyEntity> copies;
	public static volatile SingularAttribute<CheckOutEntity, LocalDate> expectedCheckInDate;
	public static volatile SingularAttribute<CheckOutEntity, CheckOutEntityId> checkOutId;

	public static final String CHECK_IN = "checkIn";
	public static final String COPIES = "copies";
	public static final String EXPECTED_CHECK_IN_DATE = "expectedCheckInDate";
	public static final String CHECK_OUT_ID = "checkOutId";

}

