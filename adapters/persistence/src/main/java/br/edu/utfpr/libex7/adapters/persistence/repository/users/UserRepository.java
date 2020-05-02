package br.edu.utfpr.libex7.adapters.persistence.repository.users;

import br.edu.utfpr.libex7.adapters.persistence.entity.users.EmployeeEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.users.StudentEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.users.UserEntity;
import br.edu.utfpr.libex7.adapters.persistence.repository.GenericRepository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class UserRepository<T extends UserEntity> extends GenericRepository<T, Long> {

    public UserRepository(Connection connection) {
        super(connection);
    }

    @Override
    public T save(T user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO USUARIO (NOME_USUARIO, DATA_NASCIMENTO_USUARIO) values (?, ?)");
            preparedStatement.setString(1,user.getName());
            preparedStatement.setDate(2, Date.valueOf(user.getDob()));
            preparedStatement.execute();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Long id = generatedKeys.getLong(1);
                user.setId(id);
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao inserir usuario",e);
        }
    }

    @Override
    public Optional<T> findById(Long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USUARIO WHERE CODIGO_USUARIO = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            T user = this.newInstance();
            if(resultSet.next()){
                Long authorId = resultSet.getLong("CODIGO_AUTOR");
                String authorName = resultSet.getString("NOME_AUTOR");
                LocalDate dob = resultSet.getDate("DATA_NASCIMENTO_USUARIO").toLocalDate();
                user.setId(authorId);
                user.setName(authorName);
                user.setDob(dob);
                return Optional.ofNullable(user);
            }
            return Optional.empty();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao consultar usuario",e);
        }
    }

    @Override
    public List<T> findAll() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USUARIO U " +
                                                                                 "LEFT JOIN SERVIDOR S " +
                                                                                           "ON U.CODIGO_USUARIO = S.CODIGO_USUARIO " +
                                                                                 "LEFT JOIN ALUNO A " +
                                                                                           "ON U.CODIGO_USUARIO = A.ALUNO");
            ResultSet resultSet = preparedStatement.executeQuery();

            List<T> users = new ArrayList<>();
            while(resultSet.next()){
                T user = this.newInstance();
                Long authorId = resultSet.getLong("CODIGO_AUTOR");
                String authorName = resultSet.getString("NOME_AUTOR");
                LocalDate dob = resultSet.getDate("DATA_NASCIMENTO_USUARIO").toLocalDate();
                user.setId(authorId);
                user.setName(authorName);
                user.setDob(dob);
                if(user instanceof EmployeeEntity){
                    Long employeeNumber = resultSet.getLong("MATRICULA_SERVIDOR");
                    ((EmployeeEntity) user).setEmployeeNumber(employeeNumber);
                }else if(user instanceof StudentEntity){
                    Long studentNumber = resultSet.getLong("REGISTRO_ALUNO");
                    ((StudentEntity) user).setStudentNumber(studentNumber);
                }
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao consultar usuarios",e);
        }
    }

    @Override
    public void remove(Long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM ALUNO WHERE CODIGO_USUARIO = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao remove usuario",e);
        }
    }

    protected abstract T newInstance();
}
