package br.edu.utfpr.libex7.application.domain.users;

import br.edu.utfpr.libex7.application.domain.phones.Phone;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Getter
public abstract class User {

    @Setter
    protected Long id;
    @Setter
    protected String name;
    @Setter
    protected LocalDate dob;
    protected List<Phone> phones = new LinkedList<>();

    public User(Long id, String name, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
    }

    public User() {
        super();
    }

    public Integer addPhone(Phone phone){
        phone.setUser(this);
        this.phones.add(phone);
        return this.phones.size();
    }

}
