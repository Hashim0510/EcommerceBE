package hashim.projects.ecommerce.productservice.Services;


import hashim.projects.ecommerce.productservice.Models.Category;
import hashim.projects.ecommerce.productservice.Models.Product;
import hashim.projects.ecommerce.productservice.Repositories.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;


    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public void getCategory(String uuid){

        Optional<Category> categoryOptional = categoryRepository.findById(UUID.fromString(uuid));

        Category category = categoryOptional.get();

        System.out.println(category);

        /*

        Basically if product attribute fetch type is lazy, and it is non-transactional. it has to throw the error. why ? read notes from category model
            as per the notes and theory it should throw the error,
            but spring has something called spring.jpa.open-in-view option which is default enabled, so that it won't throw an error
            but in production, we need to disable, so that we can consume the advantages of fetch lazy

         */

        List<Product> productList = category.getProducts();

        System.out.println(productList);

    }
}
