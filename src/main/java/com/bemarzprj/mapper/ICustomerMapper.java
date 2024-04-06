package com.bemarzprj.mapper;

import com.bemarzprj.model.dto.CustomerDto;
import com.bemarzprj.model.dto.PersonDto;
import com.bemarzprj.model.entity.CustomerEntity;
import com.bemarzprj.model.entity.PersonEntity;
import com.bemarzprj.model.entity.ProductEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface ICustomerMapper extends IBaseMapper<CustomerEntity, CustomerDto>
{
}
