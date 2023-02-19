package com.techiemeet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techiemeet.entity.ProductEntity;
import com.techiemeet.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repo;
	
	//PostMapping --> saving one product
	public ProductEntity saveProduct(ProductEntity product) {
		return repo.save(product);
	}
	
	//PostMapping --> saving all multiple products
	public List<ProductEntity> saveProducts(List<ProductEntity> products) {
		return repo.saveAll(products);
	}
	
	//GetMapping --> retrieve all product
	public List<ProductEntity> getAllProducts() {
		return repo.findAll();
	}
	
	//GetMapping --> retrieve product particular by id
	public Optional<ProductEntity> getProductById(int id) {
		return repo.findById(id);
		
	}
	
	//GetMapping --> retrieve product particular by id
	public Optional<ProductEntity> getProductByName(String name) {
			return repo.findByName(name);	
	}
	
	//DeleteMapping --> removing product by id
	public String deleteProducts(int id){
			repo.deleteById(id);
		 return "product removed is "+ id;
	}
	
	//UpdateMapping --> altering records by id
	public ProductEntity updateProduct(ProductEntity product) {
		
		ProductEntity existingProduct = repo.findById(product.getId()).orElse(null);
		
		existingProduct.setName(product.getName());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setPrice(product.getPrice());
		return repo.save(existingProduct);	
	}
	
}
