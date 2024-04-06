package com.bemarzprj.controller;

import com.bemarzprj.model.dto.BaseDto;
import com.bemarzprj.service.IBaseService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public abstract class BaseController<S extends IBaseService<Dto>, Dto extends BaseDto>
{
    private final S service;

    protected BaseController(S service)
    {
        this.service = service;
    }

    ResponseEntity<Dto> getById(Long id)
    {
        return service.getById(id);
    }

    ResponseEntity<Dto> getByModel(String model)
    {
        return service.getByModel(model);
    }

    ResponseEntity<List<Dto>> getAll()
    {
        return service.getAll();
    }

    ResponseEntity<Dto> create(Dto dto)
    {
        return service.create(dto);
    }

    ResponseEntity<Dto> update(Dto dto)
    {
        return service.update(dto);
    }

    void delete(Long id)
    {
        service.delete(id);
    }


}
