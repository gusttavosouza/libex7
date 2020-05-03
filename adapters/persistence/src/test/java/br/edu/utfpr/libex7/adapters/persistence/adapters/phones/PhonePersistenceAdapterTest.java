package br.edu.utfpr.libex7.adapters.persistence.adapters.phones;

import br.edu.utfpr.libex7.adapters.persistence.entity.phones.PhoneEntity;
import br.edu.utfpr.libex7.adapters.persistence.mapper.phones.PhonePersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.service.phones.PhonePersistenceService;
import br.edu.utfpr.libex7.application.domain.phones.Phone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PhonePersistenceAdapterTest {

    private PhonePersistenceService service;
    private PhonePersistenceMapper mapper;
    private PhonePersistenceAdapter adapter;

    @BeforeEach
    public void setup(){
        this.service = mock(PhonePersistenceService.class);
        this.mapper = new PhonePersistenceMapper();
        this.adapter = new PhonePersistenceAdapter(service,mapper);
    }

    @Test
    @DisplayName("Given New Phone When Save Then Return Saved Phone")
    public void givenNewPhoneWhenSaveThenReturnSavedPhone(){
        Phone phone = new Phone();
        when(service.save(any(PhoneEntity.class))).thenReturn(new PhoneEntity());
        Phone savedPhone = adapter.save(phone);
        assertThat(savedPhone).isNotNull();
    }

    @Test
    @DisplayName("Given User Id When Search Then Return Phone List")
    public void givenPhoneIdWhenSearchThenReturnPhone(){
        when(service.findByUserId(anyLong())).thenReturn(Arrays.asList(new PhoneEntity()));
        List<Phone> phones = adapter.findByUserId(1L);
        assertFalse(phones.isEmpty());
    }


}
