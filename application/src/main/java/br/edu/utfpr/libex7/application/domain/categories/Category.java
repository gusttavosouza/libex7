package br.edu.utfpr.libex7.application.domain.categories;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class Category {

    @Getter
    private final Long id;

    @Getter
    @Setter
    private String description;
}
