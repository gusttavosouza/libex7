package br.edu.utfpr.libex7.adapters.persistence.entity.users;

import br.edu.utfpr.libex7.adapters.persistence.entity.users.UserEntity.PhoneEntity;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserEntity.class)
public abstract class UserEntity_ {

	public static volatile SingularAttribute<UserEntity, LocalDate> dob;
	public static volatile SingularAttribute<UserEntity, String> name;
	public static volatile ListAttribute<UserEntity, PhoneEntity> phones;
	public static volatile SingularAttribute<UserEntity, Long> id;

	public static final String DOB = "dob";
	public static final String NAME = "name";
	public static final String PHONES = "phones";
	public static final String ID = "id";

}

