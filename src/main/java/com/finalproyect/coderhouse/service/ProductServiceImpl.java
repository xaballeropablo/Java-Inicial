package com.finalproyect.coderhouse.service;

import com.finalproyect.coderhouse.entity.Product;
import com.finalproyect.coderhouse.exception.DbException;
import com.finalproyect.coderhouse.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product getById(Long id) {
        log.info("Searching product by id {}", id);
        Optional<Product> productFound = productRepository.findById(id);
        if (productFound.isPresent()) {
            log.info("Product by id {} found", id);
            return productFound.get();
        } else {
            log.error("Product by id {} not found", id);
            throw new DbException("(Get) Product id not found");
        }
    }

    public Product getByName(String name) {
        log.info("Searching product by name {}", name);
        Optional<Product> productFound = Optional.ofNullable(productRepository.findByName(name));
        if (productFound.isPresent()) {
            log.info("Product by name {} found", name);
            return productFound.get();
        } else {
            log.error("Product by name {} not found", name);
            throw new DbException("(Get) Product name not found");
        }
    }

    public List<Product> getAllProducts() {
        log.info("Getting all products");
        return productRepository.findAll();
    }

    public Product saveProduct(Product product) {
        log.info("Saving new product");
        return productRepository.save(product);
    }

    public Product putProductDatabase(Product product) {
        log.info("Searching product by id {}", product.getId());
        Optional<Product> productFound = productRepository.findById(product.getId());
        if (productFound.isPresent()) {
            log.info("Product by id {} found", product.getId());
            Product putProduct = productFound.get();
            putProduct.setName(product.getName());
            log.info("Set name {} to product id {}", product.getName(), product.getId());
            putProduct.setDescription(product.getDescription());
            log.info("Set description {} to product id {}", product.getDescription(), product.getId());
            product.setPriceDollars(product.getPriceDollars());
            log.info("Set price dollars {} to product id {}", product.getPriceDollars(), product.getId());
            product.setStock(product.getStock());
            log.info("Saving new data product");
            return productRepository.save(product);
        } else {
            log.error("Product by id {} not found", product.getId());
            throw new DbException("(Put) Product id not found");
        }
    }

    public String changeStock(Long id, int stock) {
        log.info("Searching product by id {}", id);
        Optional<Product> productFound = productRepository.findById(id);
        if (productFound.isPresent()) {
            log.info("Product by id {} found", id);
            Product product = productFound.get();

            if (product.getStock() < stock) {
                log.error("Insufficient required stock");
                return "Insufficient stock, quantity available: " + product.getStock();
            } else {
                log.info("Calculating new stock");
                int newStock = product.getStock() - stock;
                product.setStock(newStock);
                log.info("Saving new stock");
                productRepository.save(product);
                return "Stock subtracted successfully, new stock: " + product.getStock();
            }

        } else {
            log.error("Product by id {} not found", id);
            return "Product by id not found";
        }
    }

    public String deleteProduct(Long id) {
        log.info("Searching product by id {}", id);
        Optional<Product> productFound = productRepository.findById(id);
        if (productFound.isPresent()) {
            log.info("Product by id {} found", id);
            Product deleteProduct = productFound.get();
            log.info("Product deleted");
            productRepository.deleteById(id);
            return "Product " + deleteProduct.getName() + " Deleted";
        } else {
            log.error("Product by id {} not found", id);
            throw new DbException("(Delete) Product id not found");
        }
    }
}
