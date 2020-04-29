package br.edu.utfpr.libex7.adapters.persistence.repository;

import br.edu.utfpr.libex7.adapters.persistence.entity.AuthorEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AuthorRepository extends GenericRepository<AuthorEntity, Long>{


    public AuthorRepository(Connection connection) {
        super(connection);
    }

    @Override
    public AuthorEntity save(AuthorEntity authorEntity) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO AUTOR (NOME_AUTOR) values (?)");
            preparedStatement.setString(1,authorEntity.getName());
            preparedStatement.execute();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Long id = generatedKeys.getLong(1);
                authorEntity.setId(id);
            }
            return authorEntity;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao inserir author",e);
        }
    }

    @Override
    protected AuthorEntity findById(Long id) {
        return null;
    }

    @Override
    protected List<AuthorEntity> findAll() {
        return null;
    }
}
