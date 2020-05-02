package br.edu.utfpr.libex7.adapters.persistence.repository.authors;

import br.edu.utfpr.libex7.adapters.persistence.entity.authors.AuthorEntity;
import br.edu.utfpr.libex7.adapters.persistence.repository.GenericRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AuthorRepository extends GenericRepository<AuthorEntity, Long> {


    public AuthorRepository(Connection connection) {
        super(connection);
    }

    @Override
    public AuthorEntity save(AuthorEntity authorEntity) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO AUTOR (NOME_AUTOR) values (?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,authorEntity.getName());
            preparedStatement.execute();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if(generatedKeys.next()){
                Long id = generatedKeys.getLong("CODIGO_AUTOR");
                authorEntity.setId(id);
            }
            return authorEntity;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao inserir autor",e);
        }
    }

    @Override
    public Optional<AuthorEntity> findById(Long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM AUTOR WHERE CODIGO_AUTOR = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            AuthorEntity authorEntity = new AuthorEntity();
            if(resultSet.next()){
                Long authorId = resultSet.getLong("CODIGO_AUTOR");
                String authorName = resultSet.getString("NOME_AUTOR");
                authorEntity.setId(authorId);
                authorEntity.setName(authorName);
                return Optional.ofNullable(authorEntity);
            }
            return Optional.empty();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao consultar autor",e);
        }
    }

    @Override
    public List<AuthorEntity> findAll() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM AUTOR");
            ResultSet resultSet = preparedStatement.executeQuery();

            List<AuthorEntity> authors = new ArrayList<>();
            while(resultSet.next()){
                AuthorEntity authorEntity = new AuthorEntity();
                Long authorId = resultSet.getLong("CODIGO_AUTOR");
                String authorName = resultSet.getString("NOME_AUTOR");
                authorEntity.setId(authorId);
                authorEntity.setName(authorName);
                authors.add(authorEntity);
            }
            return authors;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao consultar autores",e);
        }
    }

    @Override
    public void remove(Long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM AUTOR WHERE CODIGO_AUTOR = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao remover autor",e);
        }
    }
}
