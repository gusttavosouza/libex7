package br.edu.utfpr.libex7.application.service.users;

import br.edu.utfpr.libex7.application.domain.users.User;
import br.edu.utfpr.libex7.application.ports.in.users.SearchUserUseCase;
import br.edu.utfpr.libex7.application.ports.out.users.SearchUserPort;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class SearchUserService implements SearchUserUseCase {

    private final SearchUserPort searchUserPort;


    @Override
    public Optional<User> findById(Long id) {
        return searchUserPort.findById(id);
    }

    @Override
    public List<User> findByName(String name) {
        return searchUserPort.findByName(name);
    }

    @Override
    public List<User> findAll() {
        return searchUserPort.findAll();
    }
}
