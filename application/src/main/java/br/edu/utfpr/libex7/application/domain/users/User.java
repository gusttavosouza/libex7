package br.edu.utfpr.libex7.application.domain.users;

import br.edu.utfpr.libex7.application.domain.phones.Phone;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class User {

    protected Long id;
    protected String name;
    protected LocalDate dob;
    protected Phone phone;

}
