package com.finalproyect.coderhouse.service;

import com.finalproyect.coderhouse.entity.Product;

import java.util.List;

public interface ProductService {

    Product getById(Long id);

    Product getByName(String name);

    List<Product> getAllProducts();

    Product saveProduct(Product product);

    Product putProductDatabase(Product product);

    String deleteProduct(Long id);

    String changeStock(Long id, int stock);

}
