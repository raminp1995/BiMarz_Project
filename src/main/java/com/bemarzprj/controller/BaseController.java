package com.bemarzprj.controller;

import com.bemarzprj.exception.ExceptionMassages;
import com.bemarzprj.model.dto.BaseDto;
import com.bemarzprj.model.dto.ExceptionMassagesDto;
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

    ResponseEntity<Dto> getById(Long id) throws ExceptionMassages
    {
        return service.getById(id);
    }

    ResponseEntity<Dto> getByModel(String model) throws ExceptionMassages
    {
        return service.getByModel(model);
    }

    ResponseEntity<List<Dto>> getAll() throws ExceptionMassages
    {
        return service.getAll();
    }

    ResponseEntity<Dto> create(Dto dto) throws ExceptionMassages
    {
        return service.create(dto);
    }

    ResponseEntity<Dto> update(Dto dto) throws ExceptionMassages
    {
        return service.update(dto);
    }

    void delete(Long id) throws ExceptionMassages
    {
        service.delete(id);
    }


}
