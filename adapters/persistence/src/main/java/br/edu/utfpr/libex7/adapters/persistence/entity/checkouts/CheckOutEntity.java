package br.edu.utfpr.libex7.adapters.persistence.entity.checkouts;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.edu.utfpr.libex7.adapters.persistence.entity.copies.CopyEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.users.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Table(name = "EMPRESTIMO")
public class CheckOutEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@Getter
	private CheckOutEntityId checkOutId;

	@Getter
	@Setter
	@Column(name = "DATA_PREVISTA_DEVOLUCAO_EMPRESTIMO")
	private LocalDate expectedCheckInDate;

	@Getter
	@Setter
	@OneToOne
	@JoinColumn(name = "DATA_DEVOLUCAO", referencedColumnName = "DATA_DEVOLUCAO")
	private CheckInEntity checkIn;

	@ManyToMany
	@JoinTable(name = "EMPRESTIMO_EXEMPLAR",
	          joinColumns = {@JoinColumn(name="CODIGO_USUARIO", referencedColumnName = "CODIGO_USUARIO"),
	        		         @JoinColumn(name="DATA_EMPRESTIMO", referencedColumnName = "DATA_EMPRESTIMO")},
	          inverseJoinColumns = {@JoinColumn(name="CODIGO_EXEMPLAR", referencedColumnName = "CODIGO_EXEMPLAR")})
	private List<CopyEntity> copies = new LinkedList<>();

	public List<CopyEntity> getCopies() {
		return Collections.unmodifiableList(copies);
	}

	public CheckOutEntity(CheckOutEntityId checkOutId) {
		this.checkOutId = checkOutId;
	}

	@Embeddable
	@NoArgsConstructor
	@AllArgsConstructor
	public static class CheckOutEntityId implements Serializable {

		private static final long serialVersionUID = 1L;

		@Getter
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "CODIGO_USUARIO", referencedColumnName = "CODIGO_USUARIO")
		private UserEntity user;

		@Getter
		@Column(name = "DATA_EMPRESTIMO")
		private LocalDate checkOutDate;
	}

	@NoArgsConstructor
	@Entity
	@Table(name = "DEVOLUCAO")
	public class CheckInEntity implements Serializable {

		private static final long serialVersionUID = 1L;

		@Id
		@Getter
		@Column(name = "DATA_DEVOLUCAO")
		private LocalDate checkInDate;
		
	

		public CheckInEntity(LocalDate checkInDate) {
			this.checkInDate = checkInDate;
		}

	}

}
