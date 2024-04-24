package com.bemarzprj.mapper;

import com.bemarzprj.model.dto.OrderDto;
import com.bemarzprj.model.entity.OrderEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface IOrderMapper extends IBaseMapper<OrderEntity, OrderDto>
{
}
