package com.saas.catalogoapi.controller;

import com.saas.catalogoapi.dto.CategoriaRequest;
import com.saas.catalogoapi.dto.CategoriaResponse;
import com.saas.catalogoapi.dto.ProdutoRequest;
import com.saas.catalogoapi.dto.ProdutoResponse;
import com.saas.catalogoapi.service.CategoriaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categorias")
@Tag(name = "produtos", description = "endpoint para gerenciamento de categorias")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService){ this.categoriaService = categoriaService;
    }

    @GetMapping
    @Operation(summary = "listar todas as categorias", description = "lista todas a categorias")
    public ResponseEntity<List<CategoriaResponse>> listarTodos() {
        return ResponseEntity.ok(categoriaService.listarTodos());
    }

    @GetMapping("/{id}/")
    @Operation(summary = "listar por id", description = "listar categoria pelo id")
    public ResponseEntity<CategoriaResponse> bucarPorId(@PathVariable Long id){
        return ResponseEntity.ok(categoriaService.listarPorId(id));
    }

    @PostMapping
    @Operation(summary = "criar nova categoria", description = "Criar uma nova categoria")
    public ResponseEntity<CategoriaResponse> criar(@RequestBody CategoriaRequest request){
        CategoriaResponse novaCategoria = categoriaService.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaCategoria);
    }

}
