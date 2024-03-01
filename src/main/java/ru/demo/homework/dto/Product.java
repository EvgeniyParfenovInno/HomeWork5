package ru.demo.homework.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class Product {
    private Long id;
    private String account;
    private BigDecimal balance;
    private Integer type;
}
