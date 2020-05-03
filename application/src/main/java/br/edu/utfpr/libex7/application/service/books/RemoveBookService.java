package br.edu.utfpr.libex7.application.service.books;

import br.edu.utfpr.libex7.application.ports.in.books.RemoveBookUseCase;
import br.edu.utfpr.libex7.application.ports.out.books.RemoveBookPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RemoveBookService implements RemoveBookUseCase {

    private final RemoveBookPort port;

    @Override
    public void remove(Long id) {
        port.remove(id);
    }
}
