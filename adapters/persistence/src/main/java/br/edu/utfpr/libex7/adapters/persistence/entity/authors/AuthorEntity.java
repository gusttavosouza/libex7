package br.edu.utfpr.libex7.adapters.persistence.entity.authors;


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
@Table(name = "AUTOR")
@Entity
@SelectBeforeUpdate(false)
@DynamicInsert(false)
@DynamicUpdate(false)
public class AuthorEntity implements Serializable {

 
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO_AUTOR")
	@Getter
    private Long id;

   
    @Column(name="NOME_AUTOR")
    @Getter
    @Setter
    private String name;

	public AuthorEntity(Long id) {
		this.id = id;
	}
    
	
	
    
    
}
