package com.sample.springbootrediscache.service;

import com.sample.springbootrediscache.entity.Product;

public interface ProductService {

	public Product createProduct(Product product);

	public Product getProductById(Long id) throws Exception;

	public Product updateProduct(Product product);

	public String deleteProduct(Long id);

}
