package com.jhonatas.bookstore.service;

import com.jhonatas.bookstore.domain.Categoria;
import com.jhonatas.bookstore.domain.Livro;
import com.jhonatas.bookstore.repositories.LivroRepository;
import com.jhonatas.bookstore.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    @Autowired
    private CategoriaService categoriaService;

    public Livro findById(Integer id){
        Optional<Livro> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
            "Objeto não encontrado! Id: " + id + ", Tipo: " + Livro.class.getName()));
    }

    public List<Livro> findAll(Integer id_cat) {

        categoriaService.findById(id_cat);
        return repository.findAllByCategoria(id_cat);
    }
}
