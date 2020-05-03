package br.edu.utfpr.libex7.application.service.books;

import br.edu.utfpr.libex7.application.domain.books.Book;
import br.edu.utfpr.libex7.application.ports.in.books.SearchBookUseCase;
import br.edu.utfpr.libex7.application.ports.out.books.SearchBookPort;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class SearchBookService implements SearchBookUseCase {

    private final SearchBookPort port;

    @Override
    public Optional<Book> findById(Long id) {
        return port.findById(id);
    }

    @Override
    public List<Book> findByTitle(String title) {
        return port.findByTitle(title);
    }

    @Override
    public List<Book> findByAuthorName(String authorName) {
        return port.findByAuthorName(authorName);
    }

    @Override
    public List<Book> findAll() {
        return port.findAll();
    }
}
