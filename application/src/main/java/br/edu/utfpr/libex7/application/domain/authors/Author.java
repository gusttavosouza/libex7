package br.edu.utfpr.libex7.application.domain.authors;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@RequiredArgsConstructor
public class Author {

    @Getter
    private final Long id;

    @Getter
    @Setter
    private String name;

}
