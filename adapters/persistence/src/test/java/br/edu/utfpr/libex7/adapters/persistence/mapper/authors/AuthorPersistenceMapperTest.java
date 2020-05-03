package br.edu.utfpr.libex7.adapters.persistence.mapper.authors;

import br.edu.utfpr.libex7.adapters.persistence.entity.authors.AuthorEntity;
import br.edu.utfpr.libex7.application.domain.authors.Author;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AuthorPersistenceMapperTest {

    private AuthorPersistenceMapper mapper;

    @BeforeEach
    public void setup(){
        this.mapper = new AuthorPersistenceMapper();
    }


    @Test
    @DisplayName("Given Author Domain When Map Then Return Author Entity")
    public void givenAuthorDomainWhenMapThenReturnAuthorEntity(){

        Long id = 1L;
        String name = "Foo";
        Author author = new Author(id, name);

        AuthorEntity authorEntity = mapper.mapToEntity(author);

        assertThat(authorEntity.getId()).isEqualTo(author.getId());
        assertThat(authorEntity.getName()).isEqualTo(author.getName());
    }

    @Test
    @DisplayName("Given Author Entity When Map Then Return Author Domain")
    public void givenAuthorEntityWhenMapThenReturnAuthorDomain(){
        Long id = 1L;
        String name = "Foo";
        AuthorEntity authorEntity = new AuthorEntity(id, name);

        Author author = mapper.mapToDomain(authorEntity);

        assertThat(author.getId()).isEqualTo(authorEntity.getId());
        assertThat(author.getName()).isEqualTo(authorEntity.getName());
    }
}
