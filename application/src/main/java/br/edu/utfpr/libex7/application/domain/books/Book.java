package br.edu.utfpr.libex7.application.domain.books;

import br.edu.utfpr.libex7.application.domain.authors.Author;
import br.edu.utfpr.libex7.application.domain.categories.Category;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class Book {

    @Getter
    private final Long id;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private Category category;

    @Getter
    @Setter
    private Integer year;

    private List<Author> authors = new ArrayList<>();

    public List<Author> getAuthors() {
        return Collections.unmodifiableList(authors);
    }

    public Integer addAuthor(Author author){
        this.authors.add(author);
        return this.authors.size();
    }

}
