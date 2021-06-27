package com.jhonatas.bookstore.resources;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhonatas.bookstore.domain.Categoria;
import com.jhonatas.bookstore.dtos.CategoriaDTO;
import com.jhonatas.bookstore.service.CategoriaService;


@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResources {
	
	@Autowired
	private CategoriaService service;

	@GetMapping(value = "/{id")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id){
		Categoria obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll(){
		List<Categoria> list = service.findAll();
		List<CategoriaDTO> listDTO = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok(listDTO);
	}

}
