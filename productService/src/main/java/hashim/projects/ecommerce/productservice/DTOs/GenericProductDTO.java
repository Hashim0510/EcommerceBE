package hashim.projects.ecommerce.productservice.DTOs;

import hashim.projects.ecommerce.productservice.Enums.CategoryType;
import hashim.projects.ecommerce.productservice.Models.Category;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class GenericProductDTO {

    private String name;
    private String title;
    private String description;
    private Category category;
    private double price;
    private String image;

}
