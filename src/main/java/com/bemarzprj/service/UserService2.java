package com.bemarzprj.service;

import com.bemarzprj.exception.ExceptionMassages;
import com.bemarzprj.mapper.IBaseMapper;
import com.bemarzprj.mapper.IUserMapper;
import com.bemarzprj.model.dto.UserDto;
import com.bemarzprj.model.entity.UserEntity;
import com.bemarzprj.repository.IBaseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService2 extends BaseService2
{


    public UserService2(IBaseRepository<UserEntity> baseRepository, IUserMapper baseMapper)
    {
        super(baseRepository, baseMapper);
    }

    @Override
    public ResponseEntity<UserDto> getById(Long id) throws ExceptionMassages
    {
        return super.getById(id);
    }

    @Override
    public ResponseEntity<List<UserDto>> getAll() throws ExceptionMassages
    {

        return super.getAll();

    }

    @Override
    public ResponseEntity<UserDto> create(UserDto dto) throws ExceptionMassages
    {
        return super.create(dto);
    }

    @Override
    public ResponseEntity<UserDto> update(UserDto dto) throws ExceptionMassages
    {
        return super.update(dto);
    }

    @Override
    public ResponseEntity<Void> delete(Long id) throws ExceptionMassages
    {
        return super.delete(id);
    }
}