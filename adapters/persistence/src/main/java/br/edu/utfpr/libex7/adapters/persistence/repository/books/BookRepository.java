package br.edu.utfpr.libex7.adapters.persistence.repository.books;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.utfpr.libex7.adapters.persistence.entity.books.BookEntity;
import br.edu.utfpr.libex7.adapters.persistence.repository.GenericRepository;

public class BookRepository extends GenericRepository<BookEntity, Long> {

    public BookRepository(EntityManager em) {
        super(em);
    }

	public List<BookEntity> findByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<BookEntity> findByAuthorName(String authorName) {
		// TODO Auto-generated method stub
		return null;
	}

   
}
