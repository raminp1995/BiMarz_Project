package com.bemarzprj.service;

import com.bemarzprj.constants.Abilities;
import com.bemarzprj.exception.ExceptionMassages;
import com.bemarzprj.mapper.IBaseMapper;
import com.bemarzprj.mapper.IProductMapper;
import com.bemarzprj.model.dto.ProductDto;
import com.bemarzprj.model.entity.ProductEntity;
import com.bemarzprj.repository.IBaseRepository;
import com.bemarzprj.repository.IProductRepository;
import com.bemarzprj.repository.IUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductService extends BaseService<ProductEntity, ProductDto>
{
    private final UserService userService;
    private final IProductRepository productRepository;
    private final IProductMapper productMapper;

    public ProductService(IBaseRepository<ProductEntity> baseRepository, IBaseMapper<ProductEntity, ProductDto> baseMapper, UserService userService, IProductRepository productRepository, IProductMapper productMapper)
    {
        super(baseRepository, baseMapper);
        this.userService = userService;
        this.productRepository = productRepository;
        this.productMapper = productMapper;
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


    public ResponseEntity<ProductDto> findByModel(String model) throws ExceptionMassages
    {
        if (userService.checkPermission(Abilities.GET_PRODUCT))
        {
            ProductDto productDto = productMapper.entityToDto(productRepository.getByModel(model).stream().filter(i -> !i.getDeleted()).toList().getFirst());
            if (productDto == null)
            {
                throw new ExceptionMassages("No item found!");
            }
            return new ResponseEntity<>(productDto, HttpStatus.OK);
        }
        else
        {
            throw new ExceptionMassages("You can not operate this action");
        }

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
            ProductDto productDto = findByModel(dto.getModel()).getBody();
            if (productDto != null)
            {
                if (productDto.getModel().equalsIgnoreCase(dto.getModel()) && !productDto.getDeleted())
                {
                    throw new ExceptionMassages("Duplicate item!");
                }
            }
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
            ProductDto productDto = findByModel(dto.getModel()).getBody();
            assert productDto != null;
            if (productDto.getModel().equalsIgnoreCase(dto.getModel()))
            {
                dto.setId(productDto.getId());
                return super.update(dto);
            }
        }
        else
        {
            throw new ExceptionMassages("You can not operate this action");
        }
        return null;
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
