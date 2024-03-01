package ru.demo.homework.service;

import ru.demo.homework.dto.Product;
import ru.demo.homework.dto.Products;

public interface ProductService {
    Product getById(Long id);

    Products getByUserId(Long userId);
}
