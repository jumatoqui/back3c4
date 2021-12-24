package com.usa.ciclo4.reto3.controller;

import com.usa.ciclo4.reto3.model.CleaningProduct;
import com.usa.ciclo4.reto3.service.CleaningProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/cleaningproduct")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class CleaningProductController {

    @Autowired
    private CleaningProductService cleaningProductService;

    @GetMapping("/all")
    public List<CleaningProduct> getAll() {
        return cleaningProductService.getAll();
    }

    @GetMapping("/{reference}")
    public Optional<CleaningProduct> getCleaningProduct(@PathVariable("reference") String reference) {
        return cleaningProductService.getCleaningProducts(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CleaningProduct gadget){
        cleaningProductService.save(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public CleaningProduct update(@RequestBody CleaningProduct gadget){
        return cleaningProductService.save(gadget);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference){
        return cleaningProductService.delete(reference);
    }

    @GetMapping("/category/{category}")
    public List<CleaningProduct> gadgetsByCategory(@PathVariable("category") String category) {
        return cleaningProductService.gadgetsByCategory(category);
    }

    //Reto 5
    @GetMapping("/price/{precio}")
    public List<CleaningProduct> gadgetsByPrice(@PathVariable("precio") double precio) {
        return cleaningProductService.gadgetsByPrice(precio);
    }

    @GetMapping("/name/{name}")
    public List<CleaningProduct> gadgetsByName(@PathVariable("name") String name) {
        return cleaningProductService.gadgetsByName(name);
    }

    @GetMapping("/category")
    public List<String> category() {
        return cleaningProductService.getAllCategories();
    }

    //Reto 5
    @GetMapping("/description/{description}")
    public List<CleaningProduct> findByDescriptionLike(@PathVariable("description") String description) {
        return cleaningProductService.findByDescriptionLike(description);
    }



}
