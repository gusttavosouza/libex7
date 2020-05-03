package br.edu.utfpr.libex7.adapters.persistence.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ConnectionFactoryTest {

    @Test
    @DisplayName("Given Get Instance Method When Is Called Then Return Connection")
    public void givenGetInstanceMethodWhenIsCalledThenReturnConnection(){
        Connection connection = ConnectionFactory.getInstance();
        assertThat(connection).isNotNull();
    }
}
