package com.bemarzprj.controller;

import com.bemarzprj.exception.ExceptionMassages;
import com.bemarzprj.model.dto.ExceptionMassagesDto;
import com.bemarzprj.model.dto.UserDto;
import com.bemarzprj.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController<UserService, UserDto>
{
    protected UserController(UserService service)
    {
        super(service);
    }

    @GetMapping("/get/{id}")
    @Override
    ResponseEntity<UserDto> getById(@PathVariable Long id) throws ExceptionMassages
    {
        return super.getById(id);
    }

    @GetMapping("/getAll")
    @Override
    ResponseEntity<List<UserDto>> getAll() throws ExceptionMassages
    {
        return super.getAll();
    }

    @PostMapping("/create")
    @Override
    ResponseEntity<UserDto> create(@RequestBody UserDto dto) throws ExceptionMassages
    {
        return super.create(dto);
    }

    @PutMapping("/update")
    @Override
    ResponseEntity<UserDto> update(@RequestBody UserDto dto) throws ExceptionMassages
    {
        return super.update(dto);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    void delete(@PathVariable Long id) throws ExceptionMassages
    {
        super.delete(id);
    }
}
