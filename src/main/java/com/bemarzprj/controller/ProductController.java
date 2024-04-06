package com.bemarzprj.controller;

import com.bemarzprj.model.dto.ProductDto;
import com.bemarzprj.service.IBaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController extends BaseController<IBaseService<ProductDto>, ProductDto>
{
    protected ProductController(IBaseService<ProductDto> service)
    {
        super(service);
    }

    @GetMapping("/get/{id}")
    @Override
    ResponseEntity<ProductDto> getById(@PathVariable Long id)
    {
        return super.getById(id);
    }

    @GetMapping("/getByModel/{model}")
    @Override
    ResponseEntity<ProductDto> getByModel(@PathVariable String model)
    {
        return super.getByModel(model);
    }

    @GetMapping("/getAll")
    @Override
    ResponseEntity<List<ProductDto>> getAll()
    {
        return super.getAll();
    }

    @PostMapping("/create")
    @Override
    ResponseEntity<ProductDto> create(@RequestBody ProductDto dto)
    {
        return super.create(dto);
    }

    @PutMapping("/update")
    @Override
    ResponseEntity<ProductDto> update(@RequestBody ProductDto dto)
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
