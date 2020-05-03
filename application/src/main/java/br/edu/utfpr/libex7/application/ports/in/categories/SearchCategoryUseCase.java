package br.edu.utfpr.libex7.application.ports.in.categories;

import br.edu.utfpr.libex7.application.domain.categories.Category;

import java.util.List;
import java.util.Optional;

public interface SearchCategoryUseCase {
    Optional<Category> findById(Long id);
    List<Category> findByDescription(String description);
    List<Category> findAll();
}
