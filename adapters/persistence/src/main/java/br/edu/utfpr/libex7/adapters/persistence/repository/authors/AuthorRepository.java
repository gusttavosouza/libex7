package br.edu.utfpr.libex7.adapters.persistence.repository.authors;

import br.edu.utfpr.libex7.adapters.persistence.entity.authors.AuthorEntity;
import br.edu.utfpr.libex7.adapters.persistence.repository.GenericRepository;
import br.edu.utfpr.libex7.adapters.persistence.util.annotations.Id;
import br.edu.utfpr.libex7.adapters.persistence.util.relection.ReflectionUtils;
import br.edu.utfpr.libex7.application.domain.authors.Author;

import java.lang.reflect.Field;
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
                List<Field> fields = ReflectionUtils.getFields(AuthorEntity.class, Id.class);
                for (Field field : fields) {
                   ReflectionUtils.updateField(field, authorEntity, generatedKeys.getLong("CODIGO_AUTOR"));
                }
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


            if(resultSet.next()){
                Long authorId = resultSet.getLong("CODIGO_AUTOR");
                String authorName = resultSet.getString("NOME_AUTOR");
                AuthorEntity authorEntity = new AuthorEntity(authorId);
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
                Long authorId = resultSet.getLong("CODIGO_AUTOR");
                String authorName = resultSet.getString("NOME_AUTOR");
                AuthorEntity authorEntity = new AuthorEntity(authorId);
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

    public List<Author> findByName(String name) {
        return null;
    }
}
