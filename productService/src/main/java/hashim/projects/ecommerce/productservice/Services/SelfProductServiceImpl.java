package hashim.projects.ecommerce.productservice.Services;

import hashim.projects.ecommerce.productservice.DTOs.GenericProductDTO;
import hashim.projects.ecommerce.productservice.DTOs.GenericProductResponseDTO;
import hashim.projects.ecommerce.productservice.Models.Product;
import hashim.projects.ecommerce.productservice.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("SelfProductService")
public class SelfProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    @Autowired
    public SelfProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public GenericProductResponseDTO getProductById(long id) {



        return null;
    }

    @Override
    public GenericProductResponseDTO createProduct(GenericProductDTO genericProductDTO) {

        //CREATE PRODUCT :::::
        /*
        1. create a product object using GenericProductDTO
        2. save into product table
        3. return the GenericProductResponseDTO

         */

        //create a product object using GenericProductDTO
        Product product = new Product();
        product.setName(genericProductDTO.getName());
        product.setDescription(genericProductDTO.getDescription());
        product.setPrice(genericProductDTO.getPrice());
        product.setImage(genericProductDTO.getImage());
        product.setCategory(genericProductDTO.getCategory());
        product.setTitle(genericProductDTO.getTitle());

        //save into product table
        Product productResponse = productRepository.save(product);

        //return the GenericProductResponseDTO
        GenericProductResponseDTO genericProductResponseDTO = new GenericProductResponseDTO();
        genericProductResponseDTO.setId(productResponse.getUuid());
        genericProductResponseDTO.setName(productResponse.getName());
        genericProductResponseDTO.setCategory(productResponse.getCategory());
        genericProductResponseDTO.setPrice(productResponse.getPrice());
        genericProductResponseDTO.setImage(productResponse.getImage());
        genericProductResponseDTO.setDescription(productResponse.getDescription());
        genericProductResponseDTO.setTitle(productResponse.getTitle());
        return genericProductResponseDTO;

    }

    @Override
    public List<GenericProductResponseDTO> getAllProducts() {
        return List.of();
    }

    @Override
    public GenericProductResponseDTO deleteProduct(long id) {
        return null;
    }


}
