package br.edu.utfpr.libex7.adapters.persistence.mapper.users;

import br.edu.utfpr.libex7.adapters.persistence.entity.users.EmployeeEntity;
import br.edu.utfpr.libex7.adapters.persistence.mapper.phones.PhonePersistenceMapper;
import br.edu.utfpr.libex7.application.domain.users.Employee;

public class EmployeePersistenceMapper extends UserPersistenceMapper<Employee, EmployeeEntity> {



    public EmployeePersistenceMapper(PhonePersistenceMapper phonePersistenceMapper) {
        super(phonePersistenceMapper);
    }

    @Override
    public EmployeeEntity mapToEntity(Employee user) {
        EmployeeEntity employeeEntity = super.mapToEntity(user);
        employeeEntity.setEmployeeNumber(user.getEmployeeNumber());
        return employeeEntity;
    }

    @Override
    public Employee mapToDomain(EmployeeEntity userEntity) {
        Employee employee = super.mapToDomain(userEntity);
        employee.setEmployeeNumber(userEntity.getEmployeeNumber());
        return employee;
    }

    @Override
    protected Employee newInstanceDomain() {
        return new Employee();
    }

    @Override
    protected EmployeeEntity newInstanceEntity() {
        return new EmployeeEntity();
    }
}
