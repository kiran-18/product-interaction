package com.techiemeet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techiemeet.entity.ProductEntity;
import com.techiemeet.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping("/product")
	public ProductEntity addProduct(@RequestBody ProductEntity product) {
		return service.saveProduct(product);
	}
	
	@PostMapping("/products")
	public List<ProductEntity> addProducts(@RequestBody List<ProductEntity> products) {
		return service.saveProducts(products);
	}
	
	@GetMapping("/products")
	public List<ProductEntity> retrieveProducts() {
		return service.getAllProducts();	
	}
	
	@GetMapping("/product/{id}")
	public Optional<ProductEntity> retrieveProduct(@PathVariable int id) {
		return service.getProductById(id);
	}
	
	// http://localhost:9191/product?name=love
	@GetMapping("/productbyname/{name}")
	public Optional<ProductEntity> retrieveProduct(@PathVariable String name) {
		return service.getProductByName(name);
	}
	
	@DeleteMapping("/product/{id}")
	public String removeProduct(@PathVariable int id) {
		return service.deleteProducts(id);
	}
	
	@PutMapping("/update")
	public ProductEntity alterProduct(@RequestBody ProductEntity product) {
		return service.updateProduct(product);
	}
	
	
}
