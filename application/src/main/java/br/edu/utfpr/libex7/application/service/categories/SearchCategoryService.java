package br.edu.utfpr.libex7.application.service.categories;

import br.edu.utfpr.libex7.application.domain.categories.Category;
import br.edu.utfpr.libex7.application.ports.in.categories.SearchCategoryUseCase;
import br.edu.utfpr.libex7.application.ports.out.categories.SearchCategoryPort;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class SearchCategoryService implements SearchCategoryUseCase {

    private final SearchCategoryPort port;

    @Override
    public Optional<Category> findById(Long id) {
        return port.findById(id);
    }

    @Override
    public List<Category> findByDescription(String description) {
        return port.findByDescription(description);
    }

    @Override
    public List<Category> findAll() {
        return port.findAll();
    }
}
