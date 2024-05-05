package com.bemarzprj.service;

import com.bemarzprj.constants.Abilities;
import com.bemarzprj.exception.ExceptionMassages;
import com.bemarzprj.mapper.IBaseMapper;
import com.bemarzprj.model.dto.ProductDto;
import com.bemarzprj.model.entity.ProductEntity;
import com.bemarzprj.repository.IBaseRepository;
import com.bemarzprj.repository.IUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends BaseService<ProductEntity, ProductDto>
{
    private final UserService userService;

    public ProductService(IBaseRepository<ProductEntity> baseRepository, IBaseMapper<ProductEntity, ProductDto> baseMapper, UserService userService)
    {
        super(baseRepository, baseMapper);
        this.userService = userService;
    }

    @Override
    public ResponseEntity<ProductDto> getById(Long id) throws ExceptionMassages
    {
        if (userService.checkPermission(Abilities.GET_PRODUCT))
        {
            return super.getById(id);
        }
        else
        {
            throw new ExceptionMassages("You can not operate this action");
        }
    }

    @Override
    public ResponseEntity<ProductDto> getByModel(String model)
    {
        return super.getByModel(model);
    }

    @Override
    public ResponseEntity<List<ProductDto>> getAll() throws ExceptionMassages
    {
        if (userService.checkPermission(Abilities.GET_PRODUCT))
        {
            return super.getAll();
        }
        else
        {
            throw new ExceptionMassages("You can not operate this action");
        }
    }

    @Override
    public ResponseEntity<ProductDto> create(ProductDto dto) throws ExceptionMassages
    {
        if (userService.checkPermission(Abilities.ADD_PRODUCT))
        {
            return super.create(dto);
        }
        else
        {
            throw new ExceptionMassages("You can not operate this action");
        }
    }

    @Override
    public ResponseEntity<ProductDto> update(ProductDto dto) throws ExceptionMassages
    {
        if (userService.checkPermission(Abilities.EDIT_PRODUCT))
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
        if (userService.checkPermission(Abilities.REMOVE_PRODUCT))
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
