package br.edu.utfpr.libex7.adapters.persistence.mapper.users;

import java.util.List;

import br.edu.utfpr.libex7.adapters.persistence.entity.users.EmployeeEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.users.UserEntity;
import br.edu.utfpr.libex7.application.domain.users.Employee;
import br.edu.utfpr.libex7.application.domain.users.User;

public class EmployeePersistenceMapper extends UserPersistenceMapper<Employee, EmployeeEntity> {



    @Override
    public EmployeeEntity mapToEntity(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity(employee.getId());
        List<User.Phone> phones = employee.getPhones();
        phones.forEach(ph -> employeeEntity.addPhone(ph.getNumber()));
        employeeEntity.setName(employee.getName());
        employeeEntity.setDob(employee.getDob());
        employeeEntity.setEmployeeNumber(employee.getEmployeeNumber());
        return employeeEntity;
    }

    @Override
    public Employee mapToDomain(EmployeeEntity employeeEntity) {

        Employee employee = new Employee(employeeEntity.getId());
        List<UserEntity.PhoneEntity> phones = employeeEntity.getPhones();
        phones.forEach(ph -> employee.addPhone(ph.getPhoneId().getNumber()));
        employee.setName(employeeEntity.getName());
        employee.setDob(employeeEntity.getDob());
        employee.setEmployeeNumber(employeeEntity.getEmployeeNumber());
        return employee;
    }

}
