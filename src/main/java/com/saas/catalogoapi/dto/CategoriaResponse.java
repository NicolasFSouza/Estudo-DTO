package com.saas.catalogoapi.dto;

public record CategoriaResponse(
        long id,
        String nome,
        String descricao
) {
}
