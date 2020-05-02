package br.edu.utfpr.libex7.application.service.users;

import br.edu.utfpr.libex7.application.ports.in.users.RemoveUserUseCase;
import br.edu.utfpr.libex7.application.ports.out.users.RemoveUserPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RemoveUserService implements RemoveUserUseCase {

    private final RemoveUserPort removeUserPort;

    @Override
    public void remove(Long id) {
        removeUserPort.remove(id);
    }
}
