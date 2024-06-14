package com.bemarzprj.service;

import com.bemarzprj.exception.ExceptionMassages;
import com.bemarzprj.model.dto.BaseDto;
import com.bemarzprj.model.dto.UserDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IBaseService2
{
    ResponseEntity<UserDto> getById(Long id) throws ExceptionMassages;

    ResponseEntity<List<UserDto>> getAll() throws ExceptionMassages;

    ResponseEntity<UserDto> create(UserDto baseDto) throws ExceptionMassages;

    ResponseEntity<UserDto> update(UserDto baseDto) throws ExceptionMassages;

    ResponseEntity<Void> delete(Long id) throws ExceptionMassages;

//    Boolean checkPermission(String role, String ability);
}
