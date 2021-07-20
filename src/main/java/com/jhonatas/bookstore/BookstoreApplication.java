package com.jhonatas.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@SpringBootApplication
public class BookstoreApplication{


	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);

	}


	}
