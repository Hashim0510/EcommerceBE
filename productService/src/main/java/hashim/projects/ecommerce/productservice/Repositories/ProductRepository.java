package hashim.projects.ecommerce.productservice.Repositories;

import hashim.projects.ecommerce.productservice.DTOs.GenericProductResponseDTO;
import hashim.projects.ecommerce.productservice.Models.Product;
import hashim.projects.ecommerce.productservice.Services.ProductService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    public Product save(Product product);
    /*
    BELOW IS NOTHING BUT THE JPA QUERY METHODS, suppose you want to have a different output from two tables
    or any other output based on the column combinations, JPA has unique keywords which can used to create a
    CUSTOM METHOD which will be read by Hibernate and create the actual query for the method created by uniqure keywords
    REFER TO : JPA Query methods

    Jpa query methods required 2 most important things : one is , and another is predicate
        SUBJECT  ---->>> model(Product)
        predicate ----- >>> action we are going to do(e.g., findByIdAndCategory_Name)
     */
//    Product findByUuidAndCategory_Name(UUID id, String name);



    /*
    we have another method to generate custom outputs for a respective model, that is we have to write a manaul
     query to get a required output we want

        if native query is true , then we can write actual sql based query with respect to selected dialect such as postgres, mysql etc.,
        tomorrow database changes, we need to change the query based on the dialect or any other new db language, we need to change
        things. for that we have another option native query is false, in that case, jpql is a new db language which has to be written
        so that ORM(hibernate can change the query based on the dialect or any other new db language )

     */

    @Query(value = "select * from Product where title = :title", nativeQuery = true)
    Product findByTitle(String title);

    @Query(value = "SELECT p FROM Product p WHERE p.title = :title", nativeQuery = false)
    Product someFunction(@Param("title")String title);



}
