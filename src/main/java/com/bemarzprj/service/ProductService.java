package com.bemarzprj.service;

import com.bemarzprj.mapper.IBaseMapper;
import com.bemarzprj.model.dto.ProductDto;
import com.bemarzprj.model.entity.ProductEntity;
import com.bemarzprj.repository.IBaseRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends BaseService<ProductEntity, ProductDto>
{
    public ProductService(IBaseRepository<ProductEntity> baseRepository, IBaseMapper<ProductEntity, ProductDto> baseMapper)
    {
        super(baseRepository, baseMapper);
    }
}
