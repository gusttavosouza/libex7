package br.edu.utfpr.libex7.application.ports.in.users;

import br.edu.utfpr.libex7.application.domain.users.User;

import java.util.List;
import java.util.Optional;

public interface SearchUserUseCase {
    Optional<User> findById(Long id);
    List<User> findByName(String name);
    List<User> findAll();
}
