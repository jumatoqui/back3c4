package com.usa.ciclo4.reto3.crud;

import com.usa.ciclo4.reto3.model.CleaningProduct;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CleaningProductCrudRepository extends MongoRepository<CleaningProduct, String> {
}
