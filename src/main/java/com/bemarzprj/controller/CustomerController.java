package com.bemarzprj.controller;

import com.bemarzprj.model.dto.CustomerDto;
import com.bemarzprj.model.dto.CustomerDto;
import com.bemarzprj.model.dto.ProductDto;
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
    ResponseEntity<CustomerDto> getById(@PathVariable Long id)
    {
        return super.getById(id);
    }

    @GetMapping("/getAll")
    @Override
    ResponseEntity<List<CustomerDto>> getAll()
    {
        return super.getAll();
    }

    @PostMapping("/create")
    @Override
    ResponseEntity<CustomerDto> create(@RequestBody CustomerDto dto)
    {
        return super.create(dto);
    }

    @PutMapping("/update")
    @Override
    ResponseEntity<CustomerDto> update(@RequestBody CustomerDto dto)
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
