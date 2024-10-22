package hashim.projects.ecommerce.productservice.Models;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;

@Getter
@Setter
@Entity
public class Product extends BaseModel{

    private String name;
    private String title;
    private String description;
    private double price;
    @ManyToOne (cascade = { CascadeType.PERSIST }) //assuming one product will belong to one category and one category will have may products
    @JoinColumn(name = "category_id")
    private Category category;
    private String image;



}
