package ru.t1academy.consumer.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    public Page<Product> getAll(Integer offset) {
        return restTemplate.getForObject(url + "/products?offset=" + offset, Page.class );
    }

    public void update(Product product, int id) {
        restTemplate.put(url + "/products/" + id, product);
    }

    public List<Product> search(String query) {
        return restTemplate.getForObject(url + "/products/search?query=" + query, List.class);
    }


}
