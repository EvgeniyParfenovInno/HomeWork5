package ru.demo.homework.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Collections;
import java.util.List;

@Data
@Accessors(chain = true)
public class Products {
    private List<Product> items = Collections.emptyList();
}
