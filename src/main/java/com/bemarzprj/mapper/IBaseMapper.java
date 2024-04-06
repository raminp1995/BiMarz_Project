package com.bemarzprj.mapper;


import com.bemarzprj.model.dto.BaseDto;
import com.bemarzprj.model.entity.BaseEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingInheritanceStrategy;

@MapperConfig(mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_ALL_FROM_CONFIG)
public interface IBaseMapper <E, Dto>
{
    E dtoToEntity (Dto dto);

    Dto entityToDto (E entity);
}
