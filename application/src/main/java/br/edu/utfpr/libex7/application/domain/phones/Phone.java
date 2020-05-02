package br.edu.utfpr.libex7.application.domain.phones;

import br.edu.utfpr.libex7.application.domain.users.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Phone {

    private User user;
    private Long number;
}
