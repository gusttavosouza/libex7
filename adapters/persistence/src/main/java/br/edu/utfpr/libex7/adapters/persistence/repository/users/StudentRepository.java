package br.edu.utfpr.libex7.adapters.persistence.repository.users;

import br.edu.utfpr.libex7.adapters.persistence.entity.users.StudentEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class StudentRepository extends UserRepository<StudentEntity> {

    public StudentRepository(Connection connection) {
        super(connection);
    }

    @Override
    public StudentEntity save(StudentEntity user) {
        try {
            super.save(user);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ALUNO (CODIGO_USUARIO, REGISTRO_ALUNO) values (?, ?)");
            preparedStatement.setLong(1,user.getId());
            preparedStatement.setLong(2,user.getStudentNumber());
            preparedStatement.execute();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao inserir aluno",e);
        }
    }

    @Override
    public Optional<StudentEntity> findById(Long id) {
        try {
            Optional<StudentEntity> optionalUser = super.findById(id);
            if(!optionalUser.isPresent()){
                return Optional.empty();
            }
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ALUNO WHERE CODIGO_USUARIO = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            StudentEntity user = optionalUser.get();
            if(resultSet.next()){
                Long studentNumber = resultSet.getLong("REGISTRO_ALUNO");
                user.setStudentNumber(studentNumber);
                return Optional.ofNullable(user);
            }
            return Optional.empty();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao consultar aluno",e);
        }
    }

    @Override
    public void remove(Long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM ALUNO WHERE CODIGO_USUARIO = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            super.remove(id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao remove aluno",e);
        }
    }

    @Override
    protected StudentEntity newInstance() {
        return new StudentEntity();
    }
}
