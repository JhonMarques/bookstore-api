package com.jhonatas.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jhonatas.bookstore.domain.Categoria;
import com.jhonatas.bookstore.domain.Livro;
import com.jhonatas.bookstore.repositories.CategoriaRepository;
import com.jhonatas.bookstore.repositories.LivroRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria categoria = new Categoria(null, "Informatica", "Livro de TI");
		
		Livro livro = new Livro(null, "Clean Code", "Robert Martin", "Lorem ipsum", categoria);
		
		categoria.getLivros().addAll(Arrays.asList(livro));	
		
		this.categoriaRepository.saveAll(Arrays.asList(categoria));
		this.livroRepository.saveAll(Arrays.asList(livro));
	}
	

}
