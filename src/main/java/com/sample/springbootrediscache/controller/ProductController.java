package com.sample.springbootrediscache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.springbootrediscache.entity.Product;
import com.sample.springbootrediscache.service.ProductService;

@RestController
@CacheConfig(cacheNames = "product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/product")
	public Product createProduct(@RequestBody Product product) {
		return this.productService.createProduct(product);
	}

	@GetMapping("/product/{id}")
	@Cacheable(value = "product", key = "#id")
	public Product getProductById(@PathVariable Long id) throws Exception {
		return this.productService.getProductById(id);
	}

	@PutMapping("/product")
	@CachePut(cacheNames = "product", key = "#product.id")
	public Product updateProduct(@RequestBody Product product) {
		return this.productService.updateProduct(product);
	}

	@DeleteMapping("/product/{id}")
	@CacheEvict(cacheNames = "product", key = "#id", beforeInvocation = true)
	public String deleteProduct(@PathVariable Long id) {
		return this.productService.deleteProduct(id);
	}
}