package br.edu.utfpr.libex7.application.ports.out.users;

import br.edu.utfpr.libex7.application.domain.users.User;

public interface SaveUserPort {
    User save(User user);
}
