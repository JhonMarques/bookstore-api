package com.jhonatas.bookstore.resources;

import com.jhonatas.bookstore.domain.Livro;
import com.jhonatas.bookstore.dtos.LivroDTO;
import com.jhonatas.bookstore.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/livros")
public class LivroResources {

    @Autowired
    private LivroService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Integer id){

        Livro obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    //Busca livros apresentando apenas Livro.Id, Livro.Titulo, Id.Categoria e Titulo.categoria
    @GetMapping
    public ResponseEntity<List<LivroDTO>> findAll(@RequestParam (value = "categoria",
        defaultValue = "0") Integer id_cat){
        List<Livro> livros = service.findAll(id_cat);
        List<LivroDTO> listDTO = livros.stream()
            .map(obj -> new LivroDTO(obj))
            .collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
        //localhost:8080/livrod?categoria=1
    }
}
