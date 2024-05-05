package com.bemarzprj.service;

import com.bemarzprj.constants.RoleType;
import com.bemarzprj.exception.ExceptionMassages;
import com.bemarzprj.mapper.IBaseMapper;
import com.bemarzprj.model.dto.BaseDto;
import com.bemarzprj.model.entity.BaseEntity;
import com.bemarzprj.model.entity.Role;
import com.bemarzprj.model.entity.UserEntity;
import com.bemarzprj.repository.IBaseRepository;
import com.bemarzprj.repository.IUserRepository;
import com.bemarzprj.security.SecurityConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;


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
            throw new ExceptionMassages("No data founded!");
        }
        else
        {
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<Dto> getByModel(String model)
    {
        Dto dto = baseMapper.entityToDto(baseRepository.findByModel(model));
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
        dto.setCreated_at(LocalDate.now());
        Dto resultDto = baseMapper.entityToDto(baseRepository.save(baseMapper.dtoToEntity(dto)));
        return new ResponseEntity<>(resultDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Dto> update(Dto dto) throws ExceptionMassages
    {
        dto.setUpdated_at(LocalDate.now());
        Dto resultDto = baseMapper.entityToDto(baseRepository.save(baseMapper.dtoToEntity(dto)));
        return new ResponseEntity<>(resultDto, HttpStatus.OK);
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


}
