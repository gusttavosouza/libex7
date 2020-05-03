package br.edu.utfpr.libex7.application.domain.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@RequiredArgsConstructor
public abstract class User {

    @Getter
    protected final Long id;

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

    @Getter
    @AllArgsConstructor
    public static class Phone {

        private User user;
        private Long number;
    }


}
