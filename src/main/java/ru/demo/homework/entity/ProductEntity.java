package ru.demo.homework.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ProductEntity {
    private Long id;
    private String account;
    private Float balance;
    private Integer type;
    private Long userId;
}
