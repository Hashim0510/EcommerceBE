package hashim.projects.ecommerce.productservice.Controllers;


import hashim.projects.ecommerce.productservice.Services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("{uuid}")
    public void getCategory(@PathVariable("uuid") String uuid){

        categoryService.getCategory(uuid);

    }
}
