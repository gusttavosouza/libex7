package br.edu.utfpr.libex7.application.service.categories;


import br.edu.utfpr.libex7.application.domain.categories.Category;
import br.edu.utfpr.libex7.application.ports.out.categories.SearchCategoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SearchCategoryServiceTest {

    private SearchCategoryPort port;
    private SearchCategoryService service;

    @BeforeEach
    public void setup(){
        this.port = mock(SearchCategoryPort.class);
        this.service = new SearchCategoryService(port);
    }

    @Test
    @DisplayName("Given Category Id When Search Then Return Category")
    public void givenCategoryIdWhenSearchThenReturnCategory(){
        Category category = new Category(1L);
        category.setDescription( "Foo");

        when(port.findById(anyLong())).thenReturn(Optional.ofNullable(category));

        Optional<Category> optionalCategory = service.findById(1L);
        assertTrue(optionalCategory.isPresent());
    }

    @Test
    @DisplayName("Given Category Description When Search Then Return Category List")
    public void givenCategoryDescriptionWhenSearchThenReturnCategoryList(){
        Category category = new Category(1L);
        String description = "Foo";
        category.setDescription(description);

        when(port.findByDescription(anyString())).thenReturn(Arrays.asList(category));

        List<Category> categories = service.findByDescription(description);
        assertFalse(categories.isEmpty());
    }

    @Test
    @DisplayName("Given Find All Method When Is Called Then Category List")
    public void givenFindAllMethodWhenIsCalledThenReturnCategoryList(){
        Long id = 1L;
        String name = "Foo";
        Category category = new Category(id);
        category.setDescription(name);

        when(port.findAll()).thenReturn(Arrays.asList(category));

        List<Category> categories = service.findAll();
        assertFalse(categories.isEmpty());
    }
}
