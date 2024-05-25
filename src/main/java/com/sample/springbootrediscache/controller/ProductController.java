package com.sample.springbootrediscache.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/product")
	public Product createProduct(@RequestBody Product product) {
		return this.productService.createProduct(product);
	}

	@GetMapping("/product/{id}")
	public Product getProductById(@PathVariable Long id) throws Exception {
		return this.productService.getProductById(id);
	}

	@PutMapping("/product")
	public Product updateProduct(@RequestBody Product product) {
		return this.productService.updateProduct(product);
	}

	@DeleteMapping("/product/{id}")
	public String deleteProduct(@PathVariable Long id) {
		return this.productService.deleteProduct(id);
	}
}