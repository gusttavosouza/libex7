package br.edu.utfpr.libex7.adapters.persistence.entity.books;

import br.edu.utfpr.libex7.adapters.persistence.entity.authors.AuthorEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.categories.CategoryEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class BookEntity {

    @Getter
    private final Long id;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private CategoryEntity category;

    @Getter
    @Setter
    private Integer year;

    private List<AuthorEntity> authors = new ArrayList<>();

    public List<AuthorEntity> getAuthors() {
        return Collections.unmodifiableList(authors);
    }

    public Integer addAuthor(AuthorEntity author){
        this.authors.add(author);
        return this.authors.size();
    }

}
