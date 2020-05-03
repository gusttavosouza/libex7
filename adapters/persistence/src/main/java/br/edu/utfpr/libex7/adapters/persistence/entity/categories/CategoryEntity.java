package br.edu.utfpr.libex7.adapters.persistence.entity.categories;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class CategoryEntity {

    @Getter
    private final Long id;

    @Getter
    @Setter
    private String description;
}
