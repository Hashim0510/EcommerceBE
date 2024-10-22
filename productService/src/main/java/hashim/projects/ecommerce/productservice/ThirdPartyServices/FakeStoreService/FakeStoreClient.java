package hashim.projects.ecommerce.productservice.ThirdPartyServices.FakeStoreService;

import hashim.projects.ecommerce.productservice.DTOs.GenericProductDTO;
import hashim.projects.ecommerce.productservice.Exceptions.NotFoundException;
import hashim.projects.ecommerce.productservice.ThirdPartyServices.FakeStoreService.DTOs.FakeStoreProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class FakeStoreClient {

    private RestTemplateBuilder restTemplateBuilder;
    private final String productPath = "/products";
    private final String productUrl;
    private final String productRequestUrl;

    @Autowired
    public FakeStoreClient(RestTemplateBuilder restTemplateBuilder,
                           @Value("${fakeStore.api.baseurl}") String fakeStoreBaseUrl) {

        this.restTemplateBuilder = restTemplateBuilder;
        this.productUrl = fakeStoreBaseUrl + productPath + "/{id}";
        this.productRequestUrl = fakeStoreBaseUrl + productPath;

    }

    public FakeStoreProductDTO getProductById(long id) throws NotFoundException {

        /*
        RestTemplateBuilder --->>> used to build restTemplate class, becuase lots of attributes to be set manually
                                    therefore, taking help from restTemplateBuilder to build RestTemplate object

        RestTemplate        --->>> used to access the 3rd party APIs and collect the response and convert it into java objects

         */

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> response = restTemplate.getForEntity(
                productUrl,
                FakeStoreProductDTO.class,
                id
        );

        FakeStoreProductDTO fakeStoreProductDTO = response.getBody();

        if(fakeStoreProductDTO == null){

            throw new NotFoundException("product id not found !!!");

        }

        return fakeStoreProductDTO;
    }

    public FakeStoreProductDTO createProduct(GenericProductDTO genericProductDTO) throws NotFoundException {

        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDTO> response = restTemplate.postForEntity(
                productRequestUrl,
                genericProductDTO,
                FakeStoreProductDTO.class

        );

        FakeStoreProductDTO fakeStoreProductDTO = response.getBody();

        if(fakeStoreProductDTO == null){

            throw new NotFoundException("product id not found !!!");

        }

        return fakeStoreProductDTO;


    }

    public List<FakeStoreProductDTO> getAllProducts() {

        RestTemplate restTemplate = restTemplateBuilder.build();

        /*
        why are we not putting List<FakeStoreProductDTO> on getForEntity method  :
                FakeStoreProductDTO is a type in List generics, therefore at run time the type should have to
                be receiving will be erased on compile time during process of type erasure by java compiler.
                that's why we are using array which is non-generic class

         */

        ResponseEntity<FakeStoreProductDTO[]> response = restTemplate.getForEntity(
                productRequestUrl,
                FakeStoreProductDTO[].class
        );

        FakeStoreProductDTO[] fakeStoreProductDTOS = response.getBody();
//        List<GenericProductDTO> genericProductDTOList = new ArrayList<>();
//
//        for(FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOS){
//
//            GenericProductDTO genericProductDTO = new GenericProductDTO();
//            genericProductDTO.setId(fakeStoreProductDTO.getId());
//            genericProductDTO.setCategory(fakeStoreProductDTO.getCategory());
//            genericProductDTO.setDescription(fakeStoreProductDTO.getDescription());
//            genericProductDTO.setPrice(fakeStoreProductDTO.getPrice());
//            genericProductDTO.setTitle(fakeStoreProductDTO.getTitle());
//            genericProductDTO.setImage(fakeStoreProductDTO.getImage());
//            genericProductDTOList.add(genericProductDTO);
//
//        }

        return Arrays.asList(fakeStoreProductDTOS);
    }

    public FakeStoreProductDTO deleteProduct(long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        /*

        exchange method is a generic method which will be used to do any kind of httpMethod calls.
        why are we using this ?
            for delete entity, we have a delete method, but it is not returning void, but wee need to return a
            entity which has been deleted, therefore we are exchange method which is actually returning.

         */
        ResponseEntity<FakeStoreProductDTO> response = restTemplate.exchange(
                productUrl,
                HttpMethod.DELETE,
                null,
                FakeStoreProductDTO.class,
                id
        );

        FakeStoreProductDTO fakeStoreProductDTO = response.getBody();

        return fakeStoreProductDTO;

    }
}
