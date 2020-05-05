package br.edu.utfpr.libex7.adapters.persistence.mapper.users;

import br.edu.utfpr.libex7.adapters.persistence.entity.users.StudentEntity;
import br.edu.utfpr.libex7.application.domain.users.Student;

public class StudentPersistenceMapper extends UserPersistenceMapper<Student, StudentEntity> {


    @Override
    public Student mapToDomain(StudentEntity userEntity) {
        Student student = super.mapToDomain(userEntity);
        student.setStudentNumber(userEntity.getStudentNumber());
        return student;
    }

    @Override
    public StudentEntity mapToEntity(Student user) {
        StudentEntity studentEntity = super.mapToEntity(user);
        studentEntity.setStudentNumber(user.getStudentNumber());
        return studentEntity;
    }

    @Override
    protected Student newInstanceDomain(Long id) {
        return new Student(id);
    }

    @Override
    protected StudentEntity newInstanceEntity(Long id) {
        return new StudentEntity(id);
    }
}
