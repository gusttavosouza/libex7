package br.edu.utfpr.libex7.adapters.persistence.entity.users;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name="USUARIO")
@SelectBeforeUpdate(false)
@DynamicInsert(false)
@DynamicUpdate(false)
public abstract class UserEntity implements Serializable {

   
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO_USUARIO")
	@Getter
    protected Long id;

   
    @Column(name = "NOME_USUARIO")
    @Getter
    @Setter
    protected String name;

    
    @Column(name = "DATA_NASCIMENTO_USUARIO")
    @Getter
    @Setter
    protected LocalDate dob;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "phoneId.user", orphanRemoval = true)
    protected List<PhoneEntity> phones = new LinkedList<>();
    
   
    public UserEntity(Long id) {
		this.id = id;
	}
   
    public List<PhoneEntity> getPhones() {
        return Collections.unmodifiableList(phones);
    }


    public Integer addPhone(Long number){
    	PhoneEntity.PhoneEntityId phoneId = new PhoneEntity.PhoneEntityId(this, number);
        PhoneEntity phone = new PhoneEntity(phoneId);
        this.phones.add(phone);
        return this.phones.size();
    }



	@Getter
    @NoArgsConstructor
    @Table(name="TELEFONE_USUARIO")
    @Entity
    public static class PhoneEntity implements Serializable{
		
		
		private static final long serialVersionUID = 1L;
		
		@EmbeddedId
		private PhoneEntityId phoneId;
		
		
		public PhoneEntity(PhoneEntityId phoneId) {
			this.phoneId = phoneId;
		}


		@Embeddable
		@Getter
	    @NoArgsConstructor
		 public static class PhoneEntityId implements Serializable{
			
			 private static final long serialVersionUID = 1L;
				
				@ManyToOne(fetch = FetchType.LAZY)
				@JoinColumn(name = "CODIGO_USUARIO", referencedColumnName = "CODIGO_USUARIO")
		        private UserEntity user;
		       
				@Column(name = "NUMERO_TELEFONE")
				private Long number;
		        
		        
				public PhoneEntityId(UserEntity user, Long number) {
					this.user = user;
					this.number = number;
				}
		        
		        
		 }

	
		
    }


}
