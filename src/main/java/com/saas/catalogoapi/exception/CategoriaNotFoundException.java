package com.saas.catalogoapi.exception;

public class CategoriaNotFoundException extends RuntimeException {
    public CategoriaNotFoundException(Long id) {
        super("id: " + id + " Não encontrado");
    }
}
