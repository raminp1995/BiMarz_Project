package com.bemarzprj.controller;

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
    ResponseEntity<UserDto> getById(@PathVariable Long id)
    {
        return super.getById(id);
    }

    @GetMapping("/getAll")
    @Override
    ResponseEntity<List<UserDto>> getAll()
    {
        return super.getAll();
    }

    @PostMapping("/create")
    @Override
    ResponseEntity<UserDto> create(@RequestBody UserDto dto)
    {
        return super.create(dto);
    }

    @PutMapping("/update")
    @Override
    ResponseEntity<UserDto> update(@RequestBody UserDto dto)
    {
        return super.update(dto);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    void delete(@PathVariable Long id)
    {
        super.delete(id);
    }
}
