package com.bemarzprj.controller;

import com.bemarzprj.exception.ExceptionMassages;
import com.bemarzprj.model.dto.ProductDto;
import com.bemarzprj.service.IBaseService;
import com.bemarzprj.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController extends BaseController<IBaseService<ProductDto>, ProductDto>
{
    private final ProductService productService;

    protected ProductController(IBaseService<ProductDto> service, ProductService productService)
    {
        super(service);
        this.productService = productService;
    }

    @GetMapping("/get/{id}")
    @Override
    ResponseEntity<ProductDto> getById(@PathVariable Long id) throws ExceptionMassages
    {
        return super.getById(id);
    }

    @GetMapping("/findByModel/{model}")
    ResponseEntity<ProductDto> findByModel(@PathVariable String model) throws ExceptionMassages
    {
        return productService.findByModel(model);
    }

    @GetMapping("/getAll")
    @Override
    ResponseEntity<List<ProductDto>> getAll() throws ExceptionMassages
    {
        return super.getAll();
    }

    @PostMapping("/create")
    @Override
    ResponseEntity<ProductDto> create(@RequestBody ProductDto dto) throws ExceptionMassages
    {
        return super.create(dto);
    }

    @PutMapping("/edit")
    @Override
    ResponseEntity<ProductDto> update(@RequestBody ProductDto dto) throws ExceptionMassages
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
