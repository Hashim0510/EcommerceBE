package hashim.projects.ecommerce.productservice.ThirdPartyServices.FakeStoreService.DTOs;


import hashim.projects.ecommerce.productservice.Models.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
public class FakeStoreProductDTO {

    /*
    this dto class is used to receive a product details as a class which got from response
    of fakeStore API(third party API)
     */

    private UUID id;
    private String title;
    private String description;
    private Category category;
    private double price;
    private String image;

}
