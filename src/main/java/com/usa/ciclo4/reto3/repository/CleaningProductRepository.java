package com.usa.ciclo4.reto3.repository;

import com.usa.ciclo4.reto3.crud.CleaningProductCrudRepository;
import com.usa.ciclo4.reto3.model.CleaningProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CleaningProductRepository {

    @Autowired
    private CleaningProductCrudRepository cleaningProductCrudRepository;

    public List<CleaningProduct> getAll(){
        return cleaningProductCrudRepository.findAll();
    }

    public Optional<CleaningProduct> getCleaningProducts(String reference){
        return cleaningProductCrudRepository.findById(reference);
    }

    public CleaningProduct create(CleaningProduct cleaningProduct){
        return cleaningProductCrudRepository.save(cleaningProduct);
    }

    public void update(CleaningProduct cleaningProduct){
        cleaningProductCrudRepository.save(cleaningProduct);

    }

    public void delete (CleaningProduct cleaningProduct){
        cleaningProductCrudRepository.delete(cleaningProduct);
    }

}
