package com.ING_Exercize.INGExercise.service;

import com.ING_Exercize.INGExercise.dto.ProductResponse;
import com.ING_Exercize.INGExercise.exception.CustomExceptionProduct;
import com.ING_Exercize.INGExercise.model.Product;
import com.ING_Exercize.INGExercise.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product addProduct(ProductResponse product) {
        return repository.save(mapProductResponse(product));
    }

    public ProductResponse findProduct(Long id){
        Product product = repository.findById(id)
                .orElseThrow(() -> new CustomExceptionProduct("Product Not found !!!"));
        return mapToProductResponse(product);
    }

    public ProductResponse findProductByName(String name){
        Product product = repository.findByName(name)
                .orElseThrow(() -> new CustomExceptionProduct("Product Not found !!!"));

        return mapToProductResponse(product);
    }

    public ProductResponse changeProductPrice(ProductResponse productResponse) {

        Product product = repository.findByName(productResponse.name())
                .orElseThrow(() -> new CustomExceptionProduct("Product Not found !!!"));

        product.setPrice(productResponse.price());

        return mapToProductResponse(repository.save(product));
    }



    private ProductResponse mapToProductResponse(Product product) {
        return new ProductResponse(product.getName(), product.getPrice(), product.getQuantity());
    }
    private Product mapProductResponse(ProductResponse productResponse){
        return new Product(productResponse.name(),productResponse.price(),productResponse.quantity());
    }
}
