package com.sample.springbootrediscache.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.springbootrediscache.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}