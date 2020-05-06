package br.edu.utfpr.libex7.application.domain.users;

import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public abstract class User {

    @Getter
    protected Long id;

    @Getter
    @Setter
    protected String name;

    @Getter
    @Setter
    protected LocalDate dob;

    protected List<Phone> phones = new LinkedList<>();
    
   
    public List<Phone> getPhones() {
        return Collections.unmodifiableList(phones);
    }

    public Integer addPhone(Long number){
        Phone phone = new Phone(this, number);
        this.phones.add(phone);
        return this.phones.size();
    }

    public User(Long id) {
		this.id = id;
	}

	@Getter
    @AllArgsConstructor
    public static class Phone {

        private User user;
        private Long number;
    }


}
