package com.bemarzprj.service;

import com.bemarzprj.constants.Abilities;
import com.bemarzprj.exception.ExceptionMassages;
import com.bemarzprj.mapper.IBaseMapper;
import com.bemarzprj.model.dto.CustomerDto;
import com.bemarzprj.model.entity.CustomerEntity;
import com.bemarzprj.repository.IBaseRepository;
import com.bemarzprj.repository.IUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService extends BaseService<CustomerEntity, CustomerDto>
{
    public CustomerService(IBaseRepository<CustomerEntity> baseRepository, IUserRepository userRepository, IBaseMapper<CustomerEntity, CustomerDto> baseMapper)
    {
        super(baseRepository, userRepository, baseMapper);
    }


    @Override
    public ResponseEntity<CustomerDto> create(CustomerDto dto) throws ExceptionMassages
    {

        if (super.checkPermission(Abilities.ADD_CUSTOMER))
        {
            return super.update(dto);
        }
        else
        {
            throw new ExceptionMassages("You can not operate this action");
        }
    }

    @Override
    public ResponseEntity<CustomerDto> getById(Long id) throws ExceptionMassages
    {
        if (super.checkPermission(Abilities.GET_CUSTOMER))
        {
            return super.getById(id);
        }
        else
        {
            throw new ExceptionMassages("You can not operate this action");
        }
    }

    @Override
    public ResponseEntity<List<CustomerDto>> getAll() throws ExceptionMassages
    {
        if (super.checkPermission(Abilities.GET_CUSTOMER))
        {
            return super.getAll();
        }
        else
        {
            throw new ExceptionMassages("You can not operate this action");
        }
    }

    @Override
    public ResponseEntity<CustomerDto> update(CustomerDto dto) throws ExceptionMassages
    {
        if (super.checkPermission(Abilities.EDIT_CUSTOMER))
        {
            return super.update(dto);
        }
        else
        {
            throw new ExceptionMassages("You can not operate this action");
        }
    }

    @Override
    public ResponseEntity<Boolean> delete(Long id) throws ExceptionMassages
    {
        if (super.checkPermission(Abilities.REMOVE_CUSTOMER))
        {
            super.delete(id);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        else
        {
            throw new ExceptionMassages("You can not operate this action");
        }
    }
}
