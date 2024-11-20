package com.rest.resource.repositor;

import com.rest.resource.entity.CatalogyEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogyRepository extends CrudRepository<CatalogyEntity,Integer> {
    @Query(value = "from CatalogyEntity where name=:name")
    public CatalogyEntity findByName(String name);
}
