package br.edu.utfpr.libex7.adapters.persistence.entity.books;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.edu.utfpr.libex7.adapters.persistence.entity.authors.AuthorEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.categories.CategoryEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Table(name = "OBRA")
@Entity
public class BookEntity implements Serializable {


	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CODIGO_OBRA")
    @Getter
    private Long id;

    
    @Column(name="TITULO_OBRA")
    @Getter
    @Setter
    private String title;

  
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="CODIGO_TIPO_OBRA", referencedColumnName = "CODIGO_TIPO_OBRA")
    @Getter
    @Setter
    private CategoryEntity category;

    
    @Column(name="ANO_PUBLICACAO_OBRA")
    @Getter
    @Setter
    private Integer year;

    @OneToMany(fetch = FetchType.LAZY)
    private List<AuthorEntity> authors = new ArrayList<>();
    
    public BookEntity(Long id) {
		this.id = id;
	}

    public List<AuthorEntity> getAuthors() {
        return Collections.unmodifiableList(authors);
    }

    public Integer addAuthor(AuthorEntity author){
        this.authors.add(author);
        return this.authors.size();
    }

	

}
