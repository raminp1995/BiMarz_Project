package com.bemarzprj.mapper;

import com.bemarzprj.model.dto.UserDto;
import com.bemarzprj.model.entity.UserEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface IUserMapper extends IBaseMapper<UserEntity, UserDto>
{

}
