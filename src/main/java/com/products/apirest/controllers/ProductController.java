package com.products.apirest.controllers;

import com.products.apirest.models.Product;
import com.products.apirest.respository.ProductRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
@Api(value = "API REST Products")
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    @ApiOperation(value = "Retorna uma lista de todos os produdos cadastrados")
    public List<Product> listProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    @ApiOperation(value = "Retorna um produto específico de acordo o o id passado por parâmetro")
    Product listProductsById(@PathVariable(value = "id") long id){
        return productRepository.findById (id);
    }

    @PostMapping("/product")
    @ApiOperation(value = "Adiciona um novo produto à lista de produtos cadastrados")
    public Product saveProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @DeleteMapping("/product")
    @ApiOperation(value = "Deleta determinado produto de acordo com o id")
    public void deleteProduct(@RequestBody Product product){
        productRepository.delete(product);
    }

    @PutMapping("/product")
    @ApiOperation(value = "Atualiza determinado produto de acordo com o id")
    public Product updateProduct(@RequestBody Product product){
        return productRepository.save(product);
    }
}
