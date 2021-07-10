package com.jhonatas.bookstore.service;

import com.jhonatas.bookstore.domain.Categoria;
import com.jhonatas.bookstore.domain.Livro;
import com.jhonatas.bookstore.repositories.LivroRepository;
import com.jhonatas.bookstore.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    public Livro findById(Integer id){
        Optional<Livro> obj =repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
            "Objeto não encontrado! Id: " + id + ", Tipo: " + Livro.class.getName()));
    }
}
