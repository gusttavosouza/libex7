package br.edu.utfpr.libex7.adapters.persistence.entity.users;

import lombok.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@RequiredArgsConstructor
public abstract class UserEntity {

    @Getter
    protected final Long id;

    @Getter
    @Setter
    protected String name;

    @Getter
    @Setter
    protected LocalDate dob;

    protected List<PhoneEntity> phones = new LinkedList<>();

    public List<PhoneEntity> getPhones() {
        return Collections.unmodifiableList(phones);
    }


    public Integer addPhone(Long number){
        PhoneEntity phone = new PhoneEntity(this, number);
        this.phones.add(phone);
        return this.phones.size();
    }


    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PhoneEntity {

        private UserEntity user;
        private Long number;
    }


}
