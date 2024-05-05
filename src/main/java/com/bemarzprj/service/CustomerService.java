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
    private final UserService userService;
    public CustomerService(IBaseRepository<CustomerEntity> baseRepository, IBaseMapper<CustomerEntity, CustomerDto> baseMapper, UserService userService)
    {
        super(baseRepository, baseMapper);
        this.userService = userService;
    }


    @Override
    public ResponseEntity<CustomerDto> create(CustomerDto dto) throws ExceptionMassages
    {

        if (userService.checkPermission(Abilities.ADD_CUSTOMER))
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
        if (userService.checkPermission(Abilities.GET_CUSTOMER))
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
        if (userService.checkPermission(Abilities.GET_CUSTOMER))
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
        if (userService.checkPermission(Abilities.EDIT_CUSTOMER))
        {
            return super.update(dto);
        }
        else
        {
            throw new ExceptionMassages("You can not operate this action");
        }
    }

    @Override
    public ResponseEntity<Void> delete(Long id) throws ExceptionMassages
    {
        if (userService.checkPermission(Abilities.REMOVE_CUSTOMER))
        {
            super.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
        {
            throw new ExceptionMassages("You can not operate this action");
        }
    }
}
