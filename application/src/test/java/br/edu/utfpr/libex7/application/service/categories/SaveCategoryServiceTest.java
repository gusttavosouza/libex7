package br.edu.utfpr.libex7.application.service.categories;

import br.edu.utfpr.libex7.application.domain.categories.Category;
import br.edu.utfpr.libex7.application.ports.out.categories.SaveCategoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SaveCategoryServiceTest {

    private SaveCategoryPort port;
    private SaveCategoryService service;

    @BeforeEach
    public void setup(){
        this.port = mock(SaveCategoryPort.class);
        this.service = new SaveCategoryService(port);
    }

    @Test
    @DisplayName("Given Category When Save Then Return Saved Author")
    public void givenCategoryWhenSaveThenReturnSavedAuthor(){

        Long id = 1L;
        Category category = new Category(id);
        String description = "Action";
        category.setDescription(description);

        when(port.save(any(Category.class))).thenReturn(category);

        Category savedCategory = service.save(category);
        assertThat(savedCategory).isNotNull();
        assertThat(savedCategory.getId()).isEqualTo(id);
        assertThat(savedCategory.getDescription()).isEqualTo(description);
    }
}
