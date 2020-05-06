package br.edu.utfpr.libex7.adapters.persistence.mapper.users;

import java.util.List;

import br.edu.utfpr.libex7.adapters.persistence.entity.users.StudentEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.users.UserEntity;
import br.edu.utfpr.libex7.application.domain.users.Student;
import br.edu.utfpr.libex7.application.domain.users.User;

public class StudentPersistenceMapper extends UserPersistenceMapper<Student, StudentEntity> {


	@Override
    public StudentEntity mapToEntity(Student student) {

        StudentEntity studentEntity = new StudentEntity(student.getId());
        List<User.Phone> phones = student.getPhones();
        phones.forEach(ph -> studentEntity.addPhone(ph.getNumber()));
        studentEntity.setName(student.getName());
        studentEntity.setDob(student.getDob());
        studentEntity.setStudentNumber(student.getStudentNumber());
        return studentEntity;
    }

    @Override
    public Student mapToDomain(StudentEntity studentEntity) {
        Student student = new Student(studentEntity.getId());
        List<UserEntity.PhoneEntity> phones = studentEntity.getPhones();
        phones.forEach(ph -> student.addPhone(ph.getPhoneId().getNumber()));
        student.setName(studentEntity.getName());
        student.setDob(studentEntity.getDob());
        student.setStudentNumber(studentEntity.getStudentNumber());
        return student;
    }

    
}
