package com.bemarzprj.mapper;

import com.bemarzprj.model.dto.PersonDto;
import com.bemarzprj.model.entity.PersonEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface IPersonMapper extends IBaseMapper<PersonEntity, PersonDto>
{
}
