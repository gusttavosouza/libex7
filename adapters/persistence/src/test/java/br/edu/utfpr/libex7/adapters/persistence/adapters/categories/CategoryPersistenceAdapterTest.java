package br.edu.utfpr.libex7.adapters.persistence.adapters.categories;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.utfpr.libex7.adapters.persistence.entity.categories.CategoryEntity;
import br.edu.utfpr.libex7.adapters.persistence.mapper.categories.CategoryPersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.service.categories.CategoryPersistenceService;
import br.edu.utfpr.libex7.application.domain.categories.Category;

public class CategoryPersistenceAdapterTest {

    private CategoryPersistenceService service;
    private CategoryPersistenceMapper mapper;
    private CategoryPersistenceAdapter adapter;

    @BeforeEach
    public void setup(){
        this.service = mock(CategoryPersistenceService.class);
        this.mapper = new CategoryPersistenceMapper();
        this.adapter = new CategoryPersistenceAdapter(service,mapper);
    }

    @Test
    @DisplayName("Given New Category When Save Then Return Saved Category")
    public void givenNewCategoryWhenSaveThenReturnSavedCategory(){
        Category category = new Category(1L);
        category.setDescription("Foo");
        when(service.save(any(CategoryEntity.class))).thenReturn(new CategoryEntity(1L));
        Category savedCategory = adapter.save(category);
        assertThat(savedCategory).isNotNull();
    }

    @Test
    @DisplayName("Given Category Id When Exists Then Return Category")
    public void givenCategoryIdWhenExistsThenReturnCategory(){
        Category category = new Category(1L);
        category.setDescription("Foo");
        when(service.findById(anyLong())).thenReturn(Optional.ofNullable(new CategoryEntity(1L)));
        Optional<Category> optionalCategory = adapter.findById(1L);
        assertTrue(optionalCategory.isPresent());
    }

    @Test
    @DisplayName("Given Category Id When Not Exists Then Return Category")
    public void givenCategoryIdWhenNotExistsThenReturnCategory(){
        when(service.findById(anyLong())).thenReturn(Optional.ofNullable(null));
        Optional<Category> optionalCategory = adapter.findById(1L);
        assertFalse(optionalCategory.isPresent());
    }

    @Test
    @DisplayName("Given Find All Method When Is Called Then Return Category List")
    public void givenFindAllMethodWhenIsCalledThenReturnCategoryList(){
        Category category = new Category(1L);
        category.setDescription("Foo");
        when(service.findAll()).thenReturn(Arrays.asList(new CategoryEntity(1L)));
        List<Category> categories = adapter.findAll();
        assertFalse(categories.isEmpty());
    }

    @Test
    @DisplayName("Given Existing Category When Remove Then Do Nothing")
    public void givenExistingCategoryWhenRemoveThenDoNothing(){
        adapter.remove(1L);
        verify(service, times(1)).remove(anyLong());
    }
}
