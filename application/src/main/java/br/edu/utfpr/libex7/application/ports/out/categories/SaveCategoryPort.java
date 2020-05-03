package br.edu.utfpr.libex7.application.ports.out.categories;

import br.edu.utfpr.libex7.application.domain.categories.Category;

public interface SaveCategoryPort {
    Category save(Category category);
}
