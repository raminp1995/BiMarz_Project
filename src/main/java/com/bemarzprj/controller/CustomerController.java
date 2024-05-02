package com.bemarzprj.controller;

import com.bemarzprj.exception.ExceptionMassages;
import com.bemarzprj.model.dto.CustomerDto;
import com.bemarzprj.service.IBaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController extends BaseController<IBaseService<CustomerDto>, CustomerDto>
{

    protected CustomerController(IBaseService<CustomerDto> service)
    {
        super(service);
    }

    @GetMapping("/get/{id}")
    @Override
    ResponseEntity<CustomerDto> getById(@PathVariable Long id) throws ExceptionMassages
    {
        return super.getById(id);
    }

    @GetMapping("/getAll")
    @Override
    ResponseEntity<List<CustomerDto>> getAll() throws ExceptionMassages
    {
        return super.getAll();
    }

    @PostMapping("/create")
    @Override
    ResponseEntity<CustomerDto> create(@RequestBody CustomerDto dto) throws ExceptionMassages
    {
        return super.create(dto);
    }

    @PutMapping("/edit")
    @Override
    ResponseEntity<CustomerDto> update(@RequestBody CustomerDto dto) throws ExceptionMassages
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
