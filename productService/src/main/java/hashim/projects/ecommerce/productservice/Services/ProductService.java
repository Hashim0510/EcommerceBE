package hashim.projects.ecommerce.productservice.Services;

import hashim.projects.ecommerce.productservice.DTOs.GenericProductDTO;
import hashim.projects.ecommerce.productservice.DTOs.GenericProductResponseDTO;
import hashim.projects.ecommerce.productservice.Exceptions.NotFoundException;

import java.util.List;

public interface ProductService {

    public GenericProductResponseDTO getProductById(long id) throws NotFoundException;

    public GenericProductResponseDTO createProduct(GenericProductDTO genericProductDTO) throws NotFoundException;

    public List<GenericProductResponseDTO> getAllProducts();

    GenericProductResponseDTO deleteProduct(long id);
}
