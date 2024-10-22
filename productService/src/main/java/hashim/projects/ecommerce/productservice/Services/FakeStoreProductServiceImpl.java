package hashim.projects.ecommerce.productservice.Services;

import hashim.projects.ecommerce.productservice.DTOs.GenericProductDTO;
import hashim.projects.ecommerce.productservice.DTOs.GenericProductResponseDTO;
import hashim.projects.ecommerce.productservice.Exceptions.NotFoundException;
import hashim.projects.ecommerce.productservice.ThirdPartyServices.FakeStoreService.DTOs.FakeStoreProductDTO;
import hashim.projects.ecommerce.productservice.ThirdPartyServices.FakeStoreService.FakeStoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Primary  /* used to declare the subclass as a default if no subclass is sent as a argument to te constructor or adding as a dependency to a controller by application context  */

@Service("FakeStoreProductService")
public class FakeStoreProductServiceImpl implements ProductService{

    private FakeStoreClient fakeStoreClient;

    @Autowired
    public FakeStoreProductServiceImpl(FakeStoreClient fakeStoreClient) {

        this.fakeStoreClient = fakeStoreClient;

    }


    @Override
    public GenericProductResponseDTO getProductById(long id) throws NotFoundException {

        FakeStoreProductDTO fakeStoreProductDTO = fakeStoreClient.getProductById(id);

        if(fakeStoreProductDTO == null){

            throw new NotFoundException("product id not found !!!");

        }

         
        return convertFakeStoreToGenericProductResponseDTO(fakeStoreProductDTO);
    }

    @Override
    public GenericProductResponseDTO createProduct(GenericProductDTO genericProductDTO) throws NotFoundException {

        FakeStoreProductDTO fakeStoreProductDTO = fakeStoreClient.createProduct(genericProductDTO);

        if(fakeStoreProductDTO == null){

            throw new NotFoundException("product id not found !!!");

        }

        return convertFakeStoreToGenericProductResponseDTO(fakeStoreProductDTO);


    }

    @Override
    public List<GenericProductResponseDTO> getAllProducts() {


        List<FakeStoreProductDTO> fakeStoreProductDTOS = fakeStoreClient.getAllProducts();
        List<GenericProductResponseDTO> genericProductDTOList = new ArrayList<>();

        for(FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOS){

            genericProductDTOList.add(convertFakeStoreToGenericProductResponseDTO(fakeStoreProductDTO));

        }

        return genericProductDTOList;
    }

    @Override
    public GenericProductResponseDTO deleteProduct(long id) {

        FakeStoreProductDTO fakeStoreProductDTO = fakeStoreClient.deleteProduct(id);

        return convertFakeStoreToGenericProductResponseDTO(fakeStoreProductDTO);

    }

    public GenericProductResponseDTO convertFakeStoreToGenericProductResponseDTO(FakeStoreProductDTO fakeStoreProductDTO){

        GenericProductResponseDTO genericProductResponseDTO = new GenericProductResponseDTO();
        genericProductResponseDTO.setId(fakeStoreProductDTO.getId());
        genericProductResponseDTO.setCategory(fakeStoreProductDTO.getCategory());
        genericProductResponseDTO.setDescription(fakeStoreProductDTO.getDescription());
        genericProductResponseDTO.setPrice(fakeStoreProductDTO.getPrice());
        genericProductResponseDTO.setTitle(fakeStoreProductDTO.getTitle());
        genericProductResponseDTO.setImage(fakeStoreProductDTO.getImage());
        return genericProductResponseDTO;
    }
}
