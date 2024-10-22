package hashim.projects.ecommerce.productservice.Models;


import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Setter
@Getter
@MappedSuperclass
public class BaseModel {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(generator = "uuidCustomGenerator")  //we can generate a uuid using custom method, we should put that custom method name here in generator attribute
    @GenericGenerator(name = "uuidCustomGenerator",strategy = "uuid2")  //springboot gives customize method which will be having uuid version 2 implemented, need to use in the name of our custom method uuidCustomGenerator
    @Column(name  = "id",columnDefinition = "binary(16)", nullable = false, updatable = false)  //columnDefinition will tell mysql to have this type of datatype for id column i.e., binary type with 16byte space, because default it will be taking as varChar
    private UUID uuid;


}
