package hashim.projects.ecommerce.productservice.DTOs;

import hashim.projects.ecommerce.productservice.Enums.CategoryType;
import hashim.projects.ecommerce.productservice.Models.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
public class GenericProductResponseDTO {

    private UUID id;
    private String title;
    private String description;
    private Category category;
    private double price;
    private String image;
    private String name;

}
