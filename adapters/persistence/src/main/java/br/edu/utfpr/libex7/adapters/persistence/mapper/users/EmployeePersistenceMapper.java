package br.edu.utfpr.libex7.adapters.persistence.mapper.users;

import br.edu.utfpr.libex7.adapters.persistence.entity.users.EmployeeEntity;
import br.edu.utfpr.libex7.application.domain.users.Employee;

public class EmployeePersistenceMapper extends UserPersistenceMapper<Employee, EmployeeEntity> {



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
    protected Employee newInstanceDomain(Long id) {
        return new Employee(id);
    }

    @Override
    protected EmployeeEntity newInstanceEntity(Long id) {
        return new EmployeeEntity(id);
    }
}
