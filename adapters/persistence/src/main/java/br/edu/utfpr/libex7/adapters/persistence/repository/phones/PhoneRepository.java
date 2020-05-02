package br.edu.utfpr.libex7.adapters.persistence.repository.phones;

import br.edu.utfpr.libex7.adapters.persistence.entity.phones.PhoneEntity;
import br.edu.utfpr.libex7.adapters.persistence.repository.GenericRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class PhoneRepository extends GenericRepository<PhoneEntity, Long> {


    public PhoneRepository(Connection connection) {
        super(connection);
    }

    @Override
    public PhoneEntity save(PhoneEntity phoneEntity) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO TELEFONE_USUARIO (CODIGO_USUARIO, NUMERO_TELEFONE) values (?, ?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1,phoneEntity.getUser().getId());
            preparedStatement.setLong(2,phoneEntity.getNumber());
            preparedStatement.execute();
            return phoneEntity;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao inserir telefone",e);
        }
    }

    @Override
    public Optional<PhoneEntity> findById(Long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM TELEFONE_USUARIO WHERE CODIGO_TELEFONE = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            PhoneEntity phoneEntity = new PhoneEntity();
            if(resultSet.next()){
                Long phoneNumber = resultSet.getLong("NUMERO_TELEFONE");
                phoneEntity.setNumber(phoneNumber);
                return Optional.ofNullable(phoneEntity);
            }
            return Optional.empty();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao consultar telefone",e);
        }
    }

    @Override
    public List<PhoneEntity> findAll() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM TELEFONE_USUARIO");
            ResultSet resultSet = preparedStatement.executeQuery();

            List<PhoneEntity> phones = new ArrayList<>();
            while(resultSet.next()){
                PhoneEntity phoneEntity = new PhoneEntity();
                Long phoneNumber = resultSet.getLong("NUMERO_TELEFONE");
                phoneEntity.setNumber(phoneNumber);
                phones.add(phoneEntity);
            }
            return phones;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao consultar telefones",e);
        }
    }

    @Override
    public void remove(Long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM TELEFONE_USUARIO WHERE CODIGO_TELEFONE = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao remover telefone",e);
        }
    }

    public List<PhoneEntity> findByUserId(Long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM TELEFONE_USUARIO WHERE CODIGO_USUARIO = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<PhoneEntity> phoneEntities = new LinkedList<>();
            if(resultSet.next()){
                Long phoneNumber = resultSet.getLong("NUMERO_TELEFONE");
                PhoneEntity phoneEntity = new PhoneEntity();
                phoneEntity.setNumber(phoneNumber);
                phoneEntities.add(phoneEntity);
            }
            return phoneEntities;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao consultar telefones",e);
        }
    }
}
