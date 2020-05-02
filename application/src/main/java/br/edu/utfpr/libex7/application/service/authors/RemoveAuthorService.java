package br.edu.utfpr.libex7.application.service.authors;

import br.edu.utfpr.libex7.application.ports.in.authors.RemoveAuthorUseCase;
import br.edu.utfpr.libex7.application.ports.out.authors.RemoveAuthorPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RemoveAuthorService implements RemoveAuthorUseCase {

    private final RemoveAuthorPort removeAuthorPort;

    @Override
    public void remove(Long id) {
        removeAuthorPort.remove(id);
    }
}
