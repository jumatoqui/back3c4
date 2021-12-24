package com.usa.ciclo4.reto3.crud;

import com.usa.ciclo4.reto3.model.CleaningProduct;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CleaningProductCrudRepository extends MongoRepository<CleaningProduct, String> {
    public List<CleaningProduct> findByPriceLessThanEqual(double precio);

    public List<CleaningProduct> findByCategory(String categoria);

    @Query("{'name':{'$regex':'?0','$options':'i'}}")
    public List<CleaningProduct> findByNameLike(String name);

    //Reto 5
    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<CleaningProduct> findByDescriptionLike(String description);
}
