package com.bemarzprj.service;

import com.bemarzprj.mapper.IBaseMapper;
import com.bemarzprj.model.dto.UserDto;
import com.bemarzprj.model.entity.UserEntity;
import com.bemarzprj.repository.IBaseRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<UserEntity, UserDto>
{
    public UserService(IBaseRepository<UserEntity> baseRepository, IBaseMapper<UserEntity, UserDto> baseMapper)
    {
        super(baseRepository, baseMapper);
    }
}
