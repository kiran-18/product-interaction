package com.techiemeet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techiemeet.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

	Optional<ProductEntity> findByName(String name);
	
	

}
