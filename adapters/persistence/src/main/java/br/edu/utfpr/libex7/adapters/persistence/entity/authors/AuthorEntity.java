package br.edu.utfpr.libex7.adapters.persistence.entity.authors;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorEntity {

    private Long id;
    private String name;
}
