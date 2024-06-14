package com.bemarzprj.service;

import com.bemarzprj.exception.ExceptionMassages;
import com.bemarzprj.mapper.IBaseMapper;
import com.bemarzprj.model.dto.BaseDto;
import com.bemarzprj.model.entity.BaseEntity;
import com.bemarzprj.repository.IBaseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.beans.PropertyDescriptor;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;


public class BaseService<E extends BaseEntity, Dto extends BaseDto> implements IBaseService<Dto>
{
    private final IBaseRepository<E> baseRepository;
    private final IBaseMapper<E, Dto> baseMapper;

    public BaseService(IBaseRepository<E> baseRepository, IBaseMapper<E, Dto> baseMapper)
    {
        this.baseRepository = baseRepository;
        this.baseMapper = baseMapper;
    }


    @Override
    public ResponseEntity<Dto> getById(Long id) throws ExceptionMassages
    {
        Dto dto = baseMapper.entityToDto(baseRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No Data Founded!")));

        if (dto.getDeleted())
        {
            throw new ExceptionMassages("Item not found!");
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Dto>> getAll() throws ExceptionMassages
    {
        List<Dto> dto =  baseRepository.findAll().stream().filter(i -> !i.getDeleted()).map(baseMapper::entityToDto).toList();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Dto> create(Dto dto) throws ExceptionMassages
    {
        dto.setCreated_at(LocalDateTime.now());
        Dto resultDto = baseMapper.entityToDto(baseRepository.save(baseMapper.dtoToEntity(dto)));
        return new ResponseEntity<>(resultDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Dto> update(Dto dto) throws ExceptionMassages
    {
        E entity = baseRepository.findById(dto.getId()).orElseThrow(() -> new NoSuchElementException("Not found!"));
        entity.setUpdated_at(LocalDateTime.now());
        if (!entity.getDeleted())
        {
            copyNonNullProperties(dto, entity);
            return new ResponseEntity<>(baseMapper.entityToDto(baseRepository.save(entity)), HttpStatus.OK);
        }
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(Long id) throws ExceptionMassages
    {
        E entity = baseRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No Data Founded!"));
        if (entity.getDeleted())
        {
            System.out.println("No information");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else
        {
            entity.setDeleted(true);
            baseRepository.save(entity);
            System.out.println("Your information successfully deleted!");
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }


    public static void copyNonNullProperties(Object source, Object target)
    {
        BeanUtils.copyProperties(source, target, getNullPropertyName(source));
    }

    public static String[] getNullPropertyName(Object source)
    {
        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (PropertyDescriptor pd : pds)
        {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null)
            {
                emptyNames.add(pd.getName());
            }
        }

        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
