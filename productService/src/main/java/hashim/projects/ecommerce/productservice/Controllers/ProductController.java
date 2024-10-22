package hashim.projects.ecommerce.productservice.Controllers;

import hashim.projects.ecommerce.productservice.DTOs.GenericProductDTO;
import hashim.projects.ecommerce.productservice.DTOs.GenericProductResponseDTO;
import hashim.projects.ecommerce.productservice.Exceptions.ExceptionResponse;
import hashim.projects.ecommerce.productservice.Exceptions.NotFoundException;
import hashim.projects.ecommerce.productservice.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(@Qualifier("SelfProductService") ProductService productService) {

        this.productService = productService;

    }
//    @Autowired
//    public ProductController(@Qualifier("FakeStoreProductService") ProductService productService) {
//
//        this.productService = productService;
//
//    }

    @GetMapping("{id}")
    public GenericProductResponseDTO getProductById(@PathVariable("id") long id) throws NotFoundException {


        return productService.getProductById(id);

    }

    @GetMapping
    public List<GenericProductResponseDTO> getAllProducts(){

        return productService.getAllProducts();


    }

    @PostMapping
    public GenericProductResponseDTO createProduct(@RequestBody GenericProductDTO genericProductDTO) throws NotFoundException {

        return productService.createProduct(genericProductDTO);

    }

    @DeleteMapping("{id}")
    public GenericProductResponseDTO deleteProduct(@PathVariable long id){

        return productService.deleteProduct(id);

    }

    //this exception handler is particular to this controller
//    @ExceptionHandler(NotFoundException.class)
//    public ResponseEntity<ExceptionResponse> notFoundExceptionMethod(NotFoundException notFoundException){
//
//        return new ResponseEntity<>(new ExceptionResponse(HttpStatus.NOT_FOUND, notFoundException.getMessage()), HttpStatus.NOT_FOUND);
//
//    }


}
