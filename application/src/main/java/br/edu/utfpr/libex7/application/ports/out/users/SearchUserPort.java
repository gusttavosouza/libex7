package br.edu.utfpr.libex7.application.ports.out.users;

import br.edu.utfpr.libex7.application.domain.users.User;

import java.util.List;
import java.util.Optional;

public interface SearchUserPort {
    Optional<User> findById(Long id);
    List<User> findByName(String name);
    List<User> findAll();
}
