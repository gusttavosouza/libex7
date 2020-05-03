package br.edu.utfpr.libex7.application.service.categories;

import br.edu.utfpr.libex7.application.ports.in.categories.RemoveCategoryUseCase;
import br.edu.utfpr.libex7.application.ports.out.categories.RemoveCategoryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RemoveCategoryService implements RemoveCategoryUseCase {

    private final RemoveCategoryPort port;

    @Override
    public void remove(Long id) {
        port.remove(id);
    }
}
