package com.bemarzprj.service;

import com.bemarzprj.mapper.IBaseMapper;
import com.bemarzprj.model.dto.BaseDto;
import com.bemarzprj.model.entity.BaseEntity;
import com.bemarzprj.repository.IBaseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
    public ResponseEntity<Dto> getById(Long id)
    {
        Dto dto = baseMapper.entityToDto(baseRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No Data Founded!")));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Dto> getByModel(String model)
    {
        Dto dto = baseMapper.entityToDto(baseRepository.findByModel(model));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Dto>> getAll()
    {
        List<Dto> dto =  baseRepository.findAll().stream().map(baseMapper::entityToDto).toList();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Dto> create(Dto dto)
    {
        Dto resultDto = baseMapper.entityToDto(baseRepository.save(baseMapper.dtoToEntity(dto)));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Dto> update(Dto dto)
    {
        Dto resultDto = baseMapper.entityToDto(baseRepository.save(baseMapper.dtoToEntity(dto)));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Override
    public void delete(Long id)
    {

    }
}
