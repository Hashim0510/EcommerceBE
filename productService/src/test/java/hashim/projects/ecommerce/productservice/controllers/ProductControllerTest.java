package hashim.projects.ecommerce.productservice.controllers;

import hashim.projects.ecommerce.productservice.Controllers.ProductController;
import hashim.projects.ecommerce.productservice.DTOs.GenericProductDTO;
import hashim.projects.ecommerce.productservice.DTOs.GenericProductResponseDTO;
import hashim.projects.ecommerce.productservice.Exceptions.NotFoundException;
import hashim.projects.ecommerce.productservice.Services.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductControllerTest {

    @MockBean
    private ProductService productServiceMock;
    @Autowired
    private ProductController productController;


    //writing test cases just for understanding, I have not implemented anything

    @Test
    public void testGetProductByIdReturnsNullWhenProductDoesNotExist() throws NotFoundException {

        when(productServiceMock.getProductById(any(Long.class))).thenReturn(null);


        Assertions.assertNull(genericProductResponseDTO);

    }


}
