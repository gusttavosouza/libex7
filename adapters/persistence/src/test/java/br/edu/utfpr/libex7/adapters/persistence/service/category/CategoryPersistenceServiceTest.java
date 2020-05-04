package br.edu.utfpr.libex7.adapters.persistence.service.category;

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
import br.edu.utfpr.libex7.adapters.persistence.repository.categories.CategoryRepository;
import br.edu.utfpr.libex7.adapters.persistence.service.categories.CategoryPersistenceService;
import br.edu.utfpr.libex7.application.domain.categories.Category;

public class CategoryPersistenceServiceTest {

    private CategoryRepository repository;
    private CategoryPersistenceService service;


    @BeforeEach
    public void setup(){
        this.repository = mock(CategoryRepository.class);
        this.service = new CategoryPersistenceService(repository);
    }

    @Test
    @DisplayName("Given New Category When Save Then Return Saved Category")
    public void givenNewCategoryWhenSaveThenReturnSavedCategory(){
        CategoryEntity author = new CategoryEntity(1L);
        author.setDescription("Foo");
        when(repository.save(any(CategoryEntity.class))).thenReturn(new CategoryEntity(1L));
        CategoryEntity savedCategory = service.save(author);
        assertThat(savedCategory).isNotNull();
    }

    @Test
    @DisplayName("Given Category Id When Exists Then Return Category")
    public void givenCategoryIdWhenExistsThenReturnCategory(){
        CategoryEntity author = new CategoryEntity(1L);
        author.setDescription("Foo");
        when(repository.findById(anyLong())).thenReturn(Optional.ofNullable(new CategoryEntity(1L)));
        Optional<CategoryEntity> optionalCategory = service.findById(1L);
        assertTrue(optionalCategory.isPresent());
    }

    @Test
    @DisplayName("Given Category Id When Not Exists Then Return Category")
    public void givenCategoryIdWhenNotExistsThenReturnCategory(){
        when(repository.findById(anyLong())).thenReturn(Optional.ofNullable(null));
        Optional<CategoryEntity> optionalCategory = service.findById(1L);
        assertFalse(optionalCategory.isPresent());
    }

    @Test
    @DisplayName("Given Find All Method When Is Called Then Return Category List")
    public void givenFindAllMethodWhenIsCalledThenReturnCategoryList(){
        Category author = new Category(1L);
        author.setDescription("Foo");
        when(repository.findAll()).thenReturn(Arrays.asList(new CategoryEntity(1L)));
        List<CategoryEntity> categories = service.findAll();
        assertFalse(categories.isEmpty());
    }

    @Test
    @DisplayName("Given Existing Category When Remove Then Do Nothing")
    public void givenExistingCategoryWhenRemoveThenDoNothing(){
        service.remove(1L);
        verify(repository, times(1)).remove(anyLong());
    }
}
