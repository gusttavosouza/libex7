package br.edu.utfpr.libex7.adapters.persistence.mapper.users;

import br.edu.utfpr.libex7.adapters.persistence.entity.users.EmployeeEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.users.StudentEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.users.UserEntity;
import br.edu.utfpr.libex7.adapters.persistence.mapper.GenericMapper;
import br.edu.utfpr.libex7.application.domain.users.Employee;
import br.edu.utfpr.libex7.application.domain.users.Student;
import br.edu.utfpr.libex7.application.domain.users.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserPersistenceMapper<X extends User, Y extends UserEntity> extends GenericMapper<X, Y> {

    @SuppressWarnings("unchecked")
	@Override
    public X mapToDomain(Y userEntity) {
        if(userEntity instanceof EmployeeEntity) {
        	EmployeePersistenceMapper employeePersistenceMapper = new EmployeePersistenceMapper();
        	return (X) employeePersistenceMapper.mapToDomain((EmployeeEntity) userEntity);
        }else if(userEntity instanceof StudentEntity) {
        	StudentPersistenceMapper studentPersistenceMapper = new StudentPersistenceMapper();
        	return (X) studentPersistenceMapper.mapToDomain((StudentEntity) userEntity);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
	@Override
    public Y mapToEntity(X user) {
    	 if(user instanceof Employee) {
         	EmployeePersistenceMapper employeePersistenceMapper = new EmployeePersistenceMapper();
         	return (Y) employeePersistenceMapper.mapToEntity((Employee) user);
         }else if(user instanceof Student) {
         	StudentPersistenceMapper studentPersistenceMapper = new StudentPersistenceMapper();
         	return (Y) studentPersistenceMapper.mapToEntity((Student) user);
         }
         return null;
    }

}
