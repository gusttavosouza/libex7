package br.edu.utfpr.libex7.adapters.persistence.entity.phones;


import br.edu.utfpr.libex7.adapters.persistence.entity.users.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhoneEntity {

    private UserEntity user;
    private Long number;
}
