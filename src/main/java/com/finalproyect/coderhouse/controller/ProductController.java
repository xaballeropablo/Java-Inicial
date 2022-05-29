package com.finalproyect.coderhouse.controller;

import com.finalproyect.coderhouse.entity.Product;
import com.finalproyect.coderhouse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Validated
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/productId/{id}")
    public Product getProductId(@PathVariable(value = "id") @Min(1) Long id) {
        return productService.getById(id);
    }

    @GetMapping("/productName/{name}")
    public Product getProduct(@PathVariable(value = "name") @NotBlank @Pattern(regexp = "[a-zA-Z0-9]+") String name) {
        return productService.getByName(name);
    }

    @GetMapping("/product")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/productSet")
    public Product setProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PutMapping("/productPut")
    public Product putProduct(@RequestBody Product product) {
        return productService.putProductDatabase(product);
    }

    /**
     * @param id del producto, ej: 3
     * @param stock cantidad a restar ej: 30
     * @return resultado de la operación
     * localhost:8080/stockProduct/3/30
     */
    @PutMapping("/stockProduct/{id}/{stock}")
    public String productStock(@PathVariable(value = "id") @Min(1) Long id, @PathVariable(value = "stock") @Min(0) int stock) {
        return productService.changeStock(id, stock);
    }

    @DeleteMapping("/productDelete/{id}")
    public String productDelete(@PathVariable(value = "id") @Min(1) Long id) {
        return productService.deleteProduct(id);
    }
}

