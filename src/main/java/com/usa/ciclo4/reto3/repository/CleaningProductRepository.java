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

    public Optional<CleaningProduct> getCleaningProducts(String productId){
        return cleaningProductCrudRepository.findById(productId);
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

    public List<CleaningProduct> getByPrice(double precio) {
        return cleaningProductCrudRepository.findByPriceLessThanEqual(precio);
    }

    public List<CleaningProduct> getByCategory(String categoria) {
        return cleaningProductCrudRepository.findByCategory(categoria);
    }

    public List<CleaningProduct> getByName(String nombre) {
        return cleaningProductCrudRepository.findByNameLike(nombre);
    }

    //Reto 5
    public List<CleaningProduct> findByDescriptionLike(String description) {
        return cleaningProductCrudRepository.findByDescriptionLike(description);
    }



}
