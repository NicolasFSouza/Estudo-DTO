package com.saas.catalogoapi.service;

import com.saas.catalogoapi.dto.CategoriaRequest;
import com.saas.catalogoapi.dto.CategoriaResponse;
import com.saas.catalogoapi.exception.CategoriaNotFoundException;
import com.saas.catalogoapi.dto.ProdutoRequest;
import com.saas.catalogoapi.dto.ProdutoResponse;

import com.saas.catalogoapi.exception.ProdutoNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CategoriaService {
    private final List<CategoriaResponse> categorias = new ArrayList<>();
    private final AtomicLong contadorId = new AtomicLong(0);

    public CategoriaService(){
        categorias.add(new CategoriaResponse(
                contadorId.incrementAndGet(), "eletrônicos", "Itens eletrônicos"));
        categorias.add(new CategoriaResponse(
                contadorId.incrementAndGet(), "Periféricos", "Itens para computador"));

    }
    public List<CategoriaResponse> listarTodos(){return categorias;}
    public CategoriaResponse listarPorId(Long id){
        return categorias.stream().filter(categoriaResponse -> categoriaResponse.id().equals(id)).findFirst().orElseThrow(()-> new CategoriaNotFoundException(id));
    }
    public CategoriaResponse criar (CategoriaRequest request){
         CategoriaResponse novaCategoria = new CategoriaResponse(
            contadorId.incrementAndGet(),
            request.nome(),
            request.descricao()
        );
         categorias.add(novaCategoria);
         return novaCategoria;

    }

}
