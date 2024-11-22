package com.ING_Exercize.INGExercise.utitTests;

import com.ING_Exercize.INGExercise.dto.ProductResponse;
import com.ING_Exercize.INGExercise.exception.CustomExceptionProduct;
import com.ING_Exercize.INGExercise.model.Product;
import com.ING_Exercize.INGExercise.repository.ProductRepository;
import com.ING_Exercize.INGExercise.service.ProductService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ProductServiceTest {

    @Mock
    private static ProductRepository productRepository;
    @InjectMocks
    private static ProductService productService;

    private Product product;
    private ProductResponse productResponse;
//    @BeforeAll
//    public static void initialization(){
//        Exxample if we want to
////        productRepository = Mockito.mock(ProductRepository.class);
////        productService = new ProductService(productRepository);
//    }

    @AfterAll
    public static void cleanUp(){
        // write if required
    }

    @BeforeEach
    void setUp() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);

        // Prepare sample product for testing
        product = new Product();
        product.setId(1L);
        product.setName("Laptop");
        product.setPrice(new BigDecimal(1500));

        productResponse = mapToProductResponse(product);

    }

    @Test
    public void testAddNewProduct(){
        // Mock the save method to return the product
        Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn(product);

        // Call the service method
        ProductResponse response = productService.addProduct(productResponse);

        // Validate the result
        assertNotNull(response);
        assertEquals(product.getName(), response.name());
        assertEquals(product.getPrice(), response.price());
        assertEquals(product.getQuantity(), response.quantity());
    }


    @Test
    void testFindProductByName() {
        // Mock the repository method
        Mockito.when(productRepository.findByName("Laptop")).thenReturn(Optional.of(product));

        // Call the service method
        ProductResponse response = productService.findProductByName("Laptop");

        // Validate the result
        assertNotNull(response);
        assertEquals("Laptop", response.name());
        assertEquals(new BigDecimal(1500), response.price());
    }

    @Test
    void testFindProductByName_NotFound() {
        // Mock the repository method to return an empty optional
        Mockito.when(productRepository.findByName("NonExistent")).thenReturn(Optional.empty());

        // Call the service method and assert that an exception is thrown
        CustomExceptionProduct exception = assertThrows(CustomExceptionProduct.class, () -> {
            productService.findProductByName("NonExistent");
        });

        // Validate the exception message
        assertEquals("Product Not found !!!", exception.getMessage());
    }

    @Test
    void testUpdateProductPrice() {
        BigDecimal newPrice = product.getPrice().add(BigDecimal.valueOf(300));
        // Mock the repository methods
        Mockito.when(productRepository.findByName(Mockito.any())).thenReturn(Optional.of(product));
        Mockito.when(productRepository.save(Mockito.any(Product.class)))
                .thenReturn(new Product(product.getName(),
                        newPrice,
                        product.getQuantity()));
        ProductResponse response = productService.changeProductPrice(productResponse);

        // Validate the result
        assertNotNull(response);
        assertEquals(newPrice, response.price());
    }



    // Utils methods  I put it here because is faster
    private ProductResponse mapToProductResponse(Product product) {
        return new ProductResponse(product.getName(), product.getPrice(), product.getQuantity());
    }
    private Product mapProductResponse(ProductResponse productResponse){
        return new Product(productResponse.name(),productResponse.price(),productResponse.quantity());
    }
}




