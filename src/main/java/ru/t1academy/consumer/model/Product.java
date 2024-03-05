package ru.t1academy.consumer.model;

import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Product {

    private Integer id;

    private String name;

    private String description;

    private float price;

    private Integer categoryId;

}
