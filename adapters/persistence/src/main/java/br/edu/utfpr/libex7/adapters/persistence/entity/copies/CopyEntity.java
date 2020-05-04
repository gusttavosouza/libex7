package br.edu.utfpr.libex7.adapters.persistence.entity.copies;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.edu.utfpr.libex7.adapters.persistence.entity.books.BookEntity;
import lombok.Getter;
import lombok.Setter;

@Table(name="EXEMPLAR")
@Entity
public class CopyEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CODIGO_EXEMPLAR")
	@Getter
	private Long id;
	
	
	@Column(name="CODIGO_SITUACAO_EXEMPLAR")
	@Convert(converter = StatusCopyDataEnumConverter.class )
	@Getter
	@Setter
	private StatusCopyDataEnum status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODIGO_OBRA", referencedColumnName = "CODIGO_OBRA")
	@Getter
	@Setter
	private BookEntity book;
	
	@Column(name="DATA_AQUISICAO_EXEMPLAR")
	@Getter
	@Setter
	private LocalDate acquisitionDate;
	
	
	
	public CopyEntity(Long id) {
		this.id = id;
	}
	
	
	
	

}
