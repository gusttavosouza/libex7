package br.edu.utfpr.libex7.application.ports.in.users;

import br.edu.utfpr.libex7.application.domain.users.User;

public interface SaveUserUseCase {
    User save(User user);
}
