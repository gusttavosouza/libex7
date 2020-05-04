package br.edu.utfpr.libex7.adapters.persistence.mapper.categories;

import br.edu.utfpr.libex7.adapters.persistence.entity.categories.CategoryEntity;
import br.edu.utfpr.libex7.application.domain.categories.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CategoryPersistenceMapperTest {

    private CategoryPersistenceMapper mapper;

    @BeforeEach
    public void setup(){
        this.mapper = new CategoryPersistenceMapper();
    }


    @Test
    @DisplayName("Given Category Domain When Map Then Return Category Entity")
    public void givenCategoryDomainWhenMapThenReturnCategoryEntity(){

        Long id = 1L;
        String description = "Foo";
        Category category = new Category(id);
        category.setDescription(description);

        CategoryEntity categoryEntity = mapper.mapToEntity(category);

        assertThat(categoryEntity.getId()).isEqualTo(category.getId());
        assertThat(categoryEntity.getDescription()).isEqualTo(category.getDescription());
    }

    @Test
    @DisplayName("Given Category Entity When Map Then Return Category Domain")
    public void givenCategoryEntityWhenMapThenReturnCategoryDomain(){
        Long id = 1L;
        String description = "Foo";
        CategoryEntity categoryEntity = new CategoryEntity(id);
        categoryEntity.setDescription(description);

        Category category = mapper.mapToDomain(categoryEntity);

        assertThat(category.getId()).isEqualTo(categoryEntity.getId());
        assertThat(category.getDescription()).isEqualTo(categoryEntity.getDescription());
    }
}
