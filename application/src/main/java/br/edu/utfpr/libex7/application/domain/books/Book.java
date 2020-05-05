package br.edu.utfpr.libex7.application.domain.books;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.edu.utfpr.libex7.application.domain.authors.Author;
import br.edu.utfpr.libex7.application.domain.categories.Category;
import br.edu.utfpr.libex7.application.domain.copies.Copy;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Book {

    @Getter
    private Long id;

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
    
    private List<Copy> copies = new ArrayList<>();

    
    public Book(Long id) {
		this.id = id;
	}
    
    public List<Author> getAuthors() {
        return Collections.unmodifiableList(authors);
    }
    
    public List<Copy> getCopies() {
    	return Collections.unmodifiableList(copies);
	}

    public Integer addAuthor(Author author){
        this.authors.add(author);
        return this.authors.size();
    }
    
    public Integer addCopy(Copy copy){
        this.copies.add(copy);
        return this.copies.size();
    }

	

}
