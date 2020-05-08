package br.edu.utfpr.libex7.adapters.persistence.entity.categories;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Table(name="TIPO_OBRA")
@Entity
@SelectBeforeUpdate(false)
@DynamicInsert(false)
@DynamicUpdate(false)
public class CategoryEntity implements Serializable {

   
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CODIGO_TIPO_OBRA")
    @Getter
    private Long id;

	@Column(name="DESCRICAO_TIPO_OBRA")
    @Getter
    @Setter
    private String description;

	public CategoryEntity(Long id) {
		this.id = id;
	}
    
    
    
}
