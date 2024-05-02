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

    public ProductService(IBaseRepository<ProductEntity> baseRepository, IUserRepository userRepository, IBaseMapper<ProductEntity, ProductDto> baseMapper)
    {
        super(baseRepository, userRepository, baseMapper);
    }

    @Override
    public ResponseEntity<ProductDto> getById(Long id) throws ExceptionMassages
    {
        if (super.checkPermission(Abilities.GET_PRODUCT))
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
        if (super.checkPermission(Abilities.GET_PRODUCT))
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
        if (super.checkPermission(Abilities.ADD_PRODUCT))
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
        if (super.checkPermission(Abilities.EDIT_PRODUCT))
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
        if (super.checkPermission(Abilities.REMOVE_PRODUCT))
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
