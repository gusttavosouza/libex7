package br.edu.utfpr.libex7.application.ports.in.categories;

import br.edu.utfpr.libex7.application.domain.categories.Category;

public interface SaveCategoryUseCase {
    Category save(Category category);
}
