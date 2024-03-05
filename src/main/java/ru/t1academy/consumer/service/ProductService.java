package ru.t1academy.consumer.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.t1academy.consumer.model.Product;

import java.util.List;


@RequiredArgsConstructor
@Service
public class ProductService {

    private final RestTemplate restTemplate;
    private final String url = "http://localhost:8080/api/v1";

    public Product get(int id) {
        return restTemplate.getForObject(url + "/products/" + id, Product.class);
    }

    public void delete(int id) {
        restTemplate.delete(url + "/products/" + id);
    }

    public Product create(Product product) {
         return restTemplate.postForEntity(url + "/products", product, Product.class).getBody();
    }

    public List<Product> getAll() {
        return restTemplate.getForObject(url + "/products", List.class );
    }

    public void update(Product product, int id) {
        restTemplate.put(url + "/products/" + id, product);
    }


}
