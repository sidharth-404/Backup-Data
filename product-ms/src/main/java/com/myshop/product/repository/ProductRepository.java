package com.myshop.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myshop.product.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {

}
