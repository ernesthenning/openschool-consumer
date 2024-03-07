package ru.t1academy.consumer.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.t1academy.consumer.model.Product;
import ru.t1academy.consumer.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService service;

    @GetMapping("/{id}")
    public Product get(@PathVariable int id) {
        return service.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    @PostMapping
    public Product create(@Valid @RequestBody Product product) {
        return service.create(product);
    }

    @GetMapping
    public Page<Product> getAll(@RequestParam Integer offset) {
        return service.getAll(offset);
    }

    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Product product, @PathVariable int id) {
        service.update(product, id);
    }

    @GetMapping("/search")
    public List<Product> search (@RequestParam String query) {
        return service.search(query);
    }
}
