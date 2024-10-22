package hashim.projects.ecommerce.productservice.Repositories;

import hashim.projects.ecommerce.productservice.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
