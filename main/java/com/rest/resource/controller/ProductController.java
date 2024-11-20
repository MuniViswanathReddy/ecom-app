package com.rest.resource.controller;

import com.rest.resource.dto.CatalogyDto;
import com.rest.resource.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(path = "/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CatalogyDto getCatalogy(@PathVariable String name) {
        return productService.getCatalogy(name);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createCatalogy(@RequestBody CatalogyDto catalogyDto) {
        return productService.createCatalogy(catalogyDto);
    }

    @RequestMapping(path="/{name}",method = RequestMethod.DELETE)
    public String deleteCatalogy(@PathVariable("name") String name) {
        return productService.deleteCatalogy(name);
    }
}
