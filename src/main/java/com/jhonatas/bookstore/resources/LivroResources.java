package com.jhonatas.bookstore.resources;

import com.jhonatas.bookstore.domain.Livro;
import com.jhonatas.bookstore.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
