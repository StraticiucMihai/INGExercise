package com.ING_Exercize.INGExercise.controller;

import com.ING_Exercize.INGExercise.dto.ProductResponse;
import com.ING_Exercize.INGExercise.model.Product;
import com.ING_Exercize.INGExercise.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/magazine")
public class MagazineController {

    private ProductService service;

    @Autowired
    public void ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("/addProduct")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductResponse product) {
        return ResponseEntity.status(HttpStatus.OK).body(service.addProduct(product));
    }

    @GetMapping("/findById/{id}")
    @Secured("ROLE_USER")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findProduct(id));
    }

    @GetMapping("/findByProductName/{name}")
    @Secured("ROLE_USER")
    public ResponseEntity<ProductResponse> findProductByName(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findProductByName(name));
    }

    @PatchMapping("/changeProductPrice")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<ProductResponse> updateProductPrice(@RequestBody ProductResponse productResponse) {
        return ResponseEntity.status(HttpStatus.OK).body(service.changeProductPrice(productResponse));
    }
}
