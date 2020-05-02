package br.edu.utfpr.libex7.adapters.persistence.repository.users;

import br.edu.utfpr.libex7.adapters.persistence.entity.users.EmployeeEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class EmployeeRepository extends UserRepository<EmployeeEntity> {

    public EmployeeRepository(Connection connection) {
        super(connection);
    }

    @Override
    public EmployeeEntity save(EmployeeEntity user) {
        try {
            super.save(user);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO SERVIDOR (CODIGO_USUARIO, MATRICULA_SERVIDOR) values (?, ?)");
            preparedStatement.setLong(1,user.getId());
            preparedStatement.setLong(2,user.getEmployeeNumber());
            preparedStatement.execute();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao inserir usuario",e);
        }
    }

    @Override
    public Optional<EmployeeEntity> findById(Long id) {
        try {
            Optional<EmployeeEntity> optionalUser = super.findById(id);
            if(!optionalUser.isPresent()){
                return Optional.empty();
            }
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM SERVIDOR WHERE CODIGO_USUARIO = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            EmployeeEntity user = optionalUser.get();
            if(resultSet.next()){
                Long employeeNumber = resultSet.getLong("MATRICULA_SERVIDOR");
                user.setEmployeeNumber(employeeNumber);
                return Optional.ofNullable(user);
            }
            return Optional.empty();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao consultar servidor",e);
        }
    }

    @Override
    public void remove(Long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM SERVIDOR WHERE CODIGO_USUARIO = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            super.remove(id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao remove servidor",e);
        }
    }

    @Override
    protected EmployeeEntity newInstance() {
        return new EmployeeEntity();
    }
}
