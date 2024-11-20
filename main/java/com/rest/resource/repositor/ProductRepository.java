package com.rest.resource.repositor;

import com.rest.resource.entity.CatalogyEntity;
import com.rest.resource.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {
}
