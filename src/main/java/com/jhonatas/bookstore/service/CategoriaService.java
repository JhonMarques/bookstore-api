package com.jhonatas.bookstore.service;

import java.util.List;
import java.util.Optional;

import com.jhonatas.bookstore.service.exceptions.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhonatas.bookstore.domain.Categoria;
import com.jhonatas.bookstore.dtos.CategoriaDTO;
import com.jhonatas.bookstore.repositories.CategoriaRepository;
import com.jhonatas.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Categoria findById(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	public List<Categoria> findAll(){
		return repository.findAll();
	}

	public Categoria create(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Categoria update(Integer id, CategoriaDTO objDto) {
		Categoria obj = findById(id);
		obj.setNome(objDto.getNome());
		obj.setDescricao(objDto.getDescricao());
		return repository.save(obj);
	}

	public void delete(Integer id) {
		findById(id);
		try {
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new com.jhonatas.bookstore.service.exceptions.DataIntegrityViolationException(
                "Esta categoria não pode ser excluida pois possui livros associados!");
        }
	}
}
