package br.edu.utfpr.libex7.adapters.persistence.entity.authors;


import lombok.*;



@RequiredArgsConstructor
public class AuthorEntity {

    @Getter
    private final Long id;

    @Getter
    @Setter
    private String name;
}
