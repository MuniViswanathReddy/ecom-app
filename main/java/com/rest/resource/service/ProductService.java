package com.rest.resource.service;

import com.rest.resource.dto.CatalogyDto;
import com.rest.resource.dto.ProductDto;
import com.rest.resource.entity.CatalogyEntity;
import com.rest.resource.entity.ProductEntity;
import com.rest.resource.repositor.CatalogyRepository;
import com.rest.resource.repositor.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CatalogyRepository catalogyRepository;

    @Transactional
    public String createCatalogy(CatalogyDto catalogyDto) {
        CatalogyEntity catalogyEntity = new CatalogyEntity();
        catalogyEntity.setName(catalogyDto.getName());
        catalogyEntity.setDescription(catalogyDto.getDescription());
        catalogyRepository.save(catalogyEntity);
        List<ProductDto> productDtoList = catalogyDto.getProducts();
        for (ProductDto productDto : productDtoList) {
            ProductEntity productEntity = new ProductEntity();
            productEntity.setName(productDto.getName());
            productEntity.setPrice(productDto.getPrice());
            productEntity.setDiscountPrice(productDto.getDiscountPrice());
            productEntity.setDescription(productDto.getDescription());
            productEntity.setSku(productDto.getSku());
            productEntity.setQuantity(productDto.getQuantity());
            productEntity.setQuantityType(productDto.getQuantityType());
            productEntity.setCategory(productDto.getCategory());
            productEntity.setImage(productDto.getImageUrl());
            productEntity.setKeywords(productDto.getKeywords());
            productEntity.setCatalogyEntity(catalogyEntity);
            productRepository.save(productEntity);
        }
        return "Catalogy sucessfully created";
    }

    @Transactional
    public CatalogyDto getCatalogy(String name) {
        CatalogyEntity catalogyEntity = catalogyRepository.findByName(name);
        CatalogyDto catalogyDto = new CatalogyDto();
        catalogyDto.setName(catalogyEntity.getName());
        catalogyDto.setDescription(catalogyEntity.getDescription());
        List<ProductEntity> productEntityList = catalogyEntity.getProductEntityList();
        List<ProductDto> productDtoList = new ArrayList<ProductDto>();
        for (ProductEntity productEntity : productEntityList) {
            ProductDto productDto = new ProductDto();
            productDto.setName(productEntity.getName());
            productDto.setPrice(productEntity.getPrice());
            productDto.setDiscountPrice(productEntity.getDiscountPrice());
            productDto.setDescription(productEntity.getDescription());
            productDto.setSku(productEntity.getSku());
            productDto.setQuantity(productEntity.getQuantity());
            productDto.setQuantityType(productEntity.getQuantityType());
            productDto.setCategory(productEntity.getCategory());
            productDto.setImageUrl(productEntity.getImage());
            productDto.setKeywords(productEntity.getKeywords());
            productDtoList.add(productDto);
        }
        catalogyDto.setProducts(productDtoList);
        return catalogyDto;
    }

    public String deleteCatalogy(String name) {
        CatalogyEntity catalogyEntity = catalogyRepository.findByName(name);
        catalogyRepository.deleteById(catalogyEntity.getId());
        return "Catalogy sucessfully deleted";
    }
}
