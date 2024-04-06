package com.bemarzprj.mapper;

import com.bemarzprj.model.dto.ProductDto;
import com.bemarzprj.model.entity.ProductEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface IProductMapper extends IBaseMapper<ProductEntity, ProductDto>
{
}
