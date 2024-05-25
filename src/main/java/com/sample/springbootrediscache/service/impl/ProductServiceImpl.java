package com.sample.springbootrediscache.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.springbootrediscache.entity.Product;
import com.sample.springbootrediscache.repository.ProductRepository;
import com.sample.springbootrediscache.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product createProduct(Product product) {
		return this.productRepository.save(product);
	}

	@Override
	public Product getProductById(Long id) throws Exception {
		Optional<Product> product = this.productRepository.findById(id);
		if (product.isPresent()) {
			return product.get();
		}
		throw new Exception("Product with id: " + id + " not found.");
	}

	@Override
	public Product updateProduct(Product product) {
		return this.productRepository.save(product);
	}

	@Override
	public String deleteProduct(Long id) {
		try {
			this.productRepository.deleteById(id);
		} catch (Exception e) {
			return "product with id: " + id + " deletion failed.";
		}
		return "product with id: " + id + " deletion success.";
	}

}
