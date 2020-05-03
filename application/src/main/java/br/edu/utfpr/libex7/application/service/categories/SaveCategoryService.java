package br.edu.utfpr.libex7.application.service.categories;

import br.edu.utfpr.libex7.application.domain.categories.Category;
import br.edu.utfpr.libex7.application.ports.in.categories.SaveCategoryUseCase;
import br.edu.utfpr.libex7.application.ports.out.categories.SaveCategoryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SaveCategoryService implements SaveCategoryUseCase {

    private final SaveCategoryPort port;

    @Override
    public Category save(Category category) {
        return port.save(category);
    }
}
