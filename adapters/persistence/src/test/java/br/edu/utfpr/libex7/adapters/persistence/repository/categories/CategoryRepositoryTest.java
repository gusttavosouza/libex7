package br.edu.utfpr.libex7.adapters.persistence.repository.categories;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.utfpr.libex7.adapters.persistence.entity.categories.CategoryEntity;

public class CategoryRepositoryTest {

    private CategoryRepository repository;
	private static EntityManagerFactory entityManagerFactory;
    
    @BeforeAll
    public static void setupAll(){
    	entityManagerFactory = Persistence.createEntityManagerFactory("libex7");
    }

    @BeforeEach
    public void setup(){
    	EntityManager entityManager = entityManagerFactory.createEntityManager();
        this.repository = new CategoryRepository(entityManager);
    }

    @Test
    @DisplayName("Given New Category When Save Then Return Saved Category")
    public void givenNewCategoryWhenSaveThenReturnSavedCategory(){
        String description = "Foo";
        CategoryEntity authorEntity = new CategoryEntity();
        authorEntity.setDescription(description);
        CategoryEntity savedCategory = this.repository.save(authorEntity);
        assertThat(savedCategory.getId()).isNotNull();
    }


    @Test
    @DisplayName("Given Existing Category When Find By Id Then Return Category")
    public void givenExistingCategoryWhenFindByIdThenReturnCategory(){
        String description = "Foo";
        CategoryEntity authorEntity = new CategoryEntity();
        authorEntity.setDescription(description);
        CategoryEntity savedCategory = this.repository.save(authorEntity);

        Optional<CategoryEntity> optionalCategoryEntity = repository.findById(savedCategory.getId());
        assertTrue(optionalCategoryEntity.isPresent());
    }

    @Test
    @DisplayName("Given Existing Category When Remove By Id Then Do Nothing")
    public void givenExistingCategoryWhenRemoveThenDoNothing(){
        String description = "Foo";
        CategoryEntity authorEntity = new CategoryEntity();
        authorEntity.setDescription(description);
        CategoryEntity savedCategory = this.repository.save(authorEntity);
        repository.remove(savedCategory.getId());
    }


    @Test
    @DisplayName("Given Existing Categorys When Find All Then Return Category List")
    public void givenExistingCategorysWhenFindAllThenReturnCategoryList(){
        String description = "Foo";
        CategoryEntity authorEntity = new CategoryEntity();
        authorEntity.setDescription(description);
        this.repository.save(authorEntity);

        List<CategoryEntity> categoryEntites = repository.findAll();
        assertFalse(categoryEntites.isEmpty());
    }
}
