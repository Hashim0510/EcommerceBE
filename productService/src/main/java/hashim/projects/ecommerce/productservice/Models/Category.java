package hashim.projects.ecommerce.productservice.Models;

import hashim.projects.ecommerce.productservice.Enums.CategoryType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;


@Getter
@Setter
@Entity
public class Category extends BaseModel{

//    private CategoryType categoryType;
    @Enumerated(EnumType.ORDINAL)
    private CategoryType categoryType;


    /*
           what if try to access lazy initialize attributes from a parent(Category) only accessed data ?
           it will throw a lazyInitialization error ? why ?
                because once parent is fetched, hibernate will end the transaction and the child(product) was not fetched
                due to the lazy fetch type, so when we try to fetch, it will throw an error.

           what if we want to access the attribute whenever we want in a same service requests ?
           then we make that service or function as @Transactional, then it will have transactional active,
           and we can fetch the attribute whenever we want in a same transaction

           Due to this, code,memory and query performance will be improved

     */
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    /*
        fetch mode is used to tell how to write the query
        how it is beneficial ?
           basically if attr is lazy and transactional, hibernate write plain select query to fetch parent first,
           if child wants to be fetched in some time, it would be writing basic select query without joins
           but in eager, it would write one query to fetch both parent and child in a same using joins which is
           costlier in case of large data
           what fetchMode is doing here ?
           what if we want the configuration on how to write the query ?
            in that place fetch mode comes. But in some cases, it won't take our configuration, and hibernate take its own decision
     */
    /*
    what is n + 1 problem arise in fetch lazy on ORMs?
        Breakdown of the N+1 Problem:
            The 1 query: When you retrieve an entity, Spring Data JPA (through Hibernate) executes a query to fetch the parent entity.
            The N queries: For each of the N related entities (e.g., child entities in a collection or related rows in another table), it executes a separate query to load them.

            Query 1: Fetches all orders (select * from orders).
            Query N: For each order, a separate query is run to fetch the products (select * from products where order_id = ?).
            TOTAL = N + 1 QUERIES

            how to neglect this ?
            1. using eager fetching
            2. using batch processing(need to learn)
            3.write own queries to generate a single using jpql or native query
            4. entity graphs(need to learn)
     */
    private List<Product> products;


}
