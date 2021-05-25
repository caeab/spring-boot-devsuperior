package com.devsuperior.myfirstproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.myfirstproject.entities.Product;
import com.devsuperior.myfirstproject.repositories.ProductRepository;

@RestController // Indica que é uma aplicação Rest - para que o framework reconheça esse recurso rest
@RequestMapping(value = "/products") // para ter mapeamento URL
public class ProductResource {
	

	@Autowired
	private ProductRepository categoryRepository;
	
	@GetMapping // Diz que quando executar get nesse caminho vai ser chamado esse método
	public ResponseEntity<List<Product>> findAll() {		
		
		List<Product> list = categoryRepository.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		
		Product cat = categoryRepository.findById(id).get();
		
		return ResponseEntity.ok().body(cat);
	}
	
	
	

}
