package br.edu.utfpr.libex7.application.service.users;

import br.edu.utfpr.libex7.application.domain.users.User;
import br.edu.utfpr.libex7.application.ports.in.users.SaveUserUseCase;
import br.edu.utfpr.libex7.application.ports.out.users.SaveUserPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SaveUserService implements SaveUserUseCase {

    private final SaveUserPort saveUserPort;

    @Override
    public User save(User user) {
        return saveUserPort.save(user);
    }
}
