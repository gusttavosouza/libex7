package br.edu.utfpr.libex7.adapters.persistence.service.phones;

import br.edu.utfpr.libex7.adapters.persistence.entity.phones.PhoneEntity;
import br.edu.utfpr.libex7.adapters.persistence.repository.phones.PhoneRepository;
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

public class PhonePersistenceServiceTest {

    private PhoneRepository repository;
    private PhonePersistenceService service;


    @BeforeEach
    public void setup(){
        this.repository = mock(PhoneRepository.class);
        this.service = new PhonePersistenceService(repository);
    }

    @Test
    @DisplayName("Given New Phone When Save Then Return Saved Phone")
    public void givenNewPhoneWhenSaveThenReturnSavedPhone(){
        PhoneEntity phone = new PhoneEntity();
        when(repository.save(any(PhoneEntity.class))).thenReturn(new PhoneEntity());
        PhoneEntity savedPhone = service.save(phone);
        assertThat(savedPhone).isNotNull();
    }

    @Test
    @DisplayName("Given User Id When Search Then Return Phone List")
    public void givenPhoneIdWhenSearchThenReturnPhone(){
        when(repository.findByUserId(anyLong())).thenReturn(Arrays.asList(new PhoneEntity()));
        List<PhoneEntity> phones = service.findByUserId(1L);
        assertFalse(phones.isEmpty());
    }


}
