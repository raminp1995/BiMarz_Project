package com.bemarzprj.repository;

import com.bemarzprj.exception.ExceptionMassages;
import com.bemarzprj.model.dto.ProductDto;
import com.bemarzprj.model.entity.ProductEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends IBaseRepository<ProductEntity>
{
    List<ProductEntity> getByModel(String model) throws ExceptionMassages;
}
