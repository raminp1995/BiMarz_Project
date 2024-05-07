package com.bemarzprj.service;

import com.bemarzprj.exception.ExceptionMassages;
import com.bemarzprj.model.dto.BaseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IBaseService<Dto extends BaseDto>
{
    ResponseEntity<Dto> getById(Long id) throws ExceptionMassages;

    ResponseEntity<Dto> getByModel(String model) throws ExceptionMassages;

    ResponseEntity<List<Dto>> getAll() throws ExceptionMassages;

    ResponseEntity<Dto> create(Dto dto) throws ExceptionMassages;

    ResponseEntity<Dto> update(Dto dto) throws ExceptionMassages;

    ResponseEntity<Void> delete(Long id) throws ExceptionMassages;

//    Boolean checkPermission(String role, String ability);
}
