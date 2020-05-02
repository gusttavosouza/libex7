package br.edu.utfpr.libex7.adapters.persistence.repository.users;

import br.edu.utfpr.libex7.adapters.persistence.entity.phones.PhoneEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.users.EmployeeEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.users.StudentEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.users.UserEntity;
import br.edu.utfpr.libex7.adapters.persistence.repository.GenericRepository;
import br.edu.utfpr.libex7.adapters.persistence.repository.phones.PhoneRepository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class UserRepository<T extends UserEntity> extends GenericRepository<T, Long> {

    private final PhoneRepository phoneRepository;

    public UserRepository(Connection connection) {
        super(connection);
        this.phoneRepository = new PhoneRepository(connection);
    }

    @Override
    public T save(T user) {
        try {
            var preparedStatement = connection.prepareStatement("INSERT INTO USUARIO (NOME_USUARIO, DATA_NASCIMENTO_USUARIO) values (?, ?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setDate(2, Date.valueOf(user.getDob()));
            preparedStatement.execute();
            var generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Long id = generatedKeys.getLong(1);
                user.setId(id);
            }
            List<PhoneEntity> phones = user.getPhones();
            phones.forEach(ph -> phoneRepository.save(ph));
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao inserir usuario",e);
        }
    }

    @Override
    public Optional<T> findById(Long id) {
        try {
            var preparedStatement = connection.prepareStatement("SELECT * FROM USUARIO WHERE CODIGO_USUARIO = ?");
            preparedStatement.setLong(1, id);
            var resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                T user = createUser(resultSet);
                List<PhoneEntity> phoneEntities = phoneRepository.findByUserId(user.getId());
                phoneEntities.forEach(ph -> user.addPhone(ph));
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
            var preparedStatement = connection.prepareStatement("SELECT * FROM USUARIO U " +
                                                                   "LEFT JOIN SERVIDOR S " +
                                                                             "ON U.CODIGO_USUARIO = S.CODIGO_USUARIO " +
                                                                   "LEFT JOIN ALUNO A " +
                                                                             "ON U.CODIGO_USUARIO = A.CODIGO_USUARIO");
            var resultSet = preparedStatement.executeQuery();

            List<T> users = new ArrayList<>();
            while(resultSet.next()){
                T user = createUser(resultSet);
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

    private T createUser(ResultSet resultSet) throws SQLException {
        T user = this.newInstance();
        Long userId = resultSet.getLong("CODIGO_USUARIO");
        String userName = resultSet.getString("NOME_USUARIO");
        LocalDate dob = resultSet.getDate("DATA_NASCIMENTO_USUARIO").toLocalDate();
        user.setId(userId);
        user.setName(userName);
        user.setDob(dob);
        List<PhoneEntity> phoneEntities = phoneRepository.findByUserId(user.getId());
        phoneEntities.forEach(ph -> user.addPhone(ph));
        return user;
    }

    @Override
    public void remove(Long id) {
        try {
            var preparedStatement = connection.prepareStatement("DELETE FROM ALUNO WHERE CODIGO_USUARIO = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao remove usuario",e);
        }
    }

    protected abstract T newInstance();
}
