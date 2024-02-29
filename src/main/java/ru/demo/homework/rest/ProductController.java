package ru.demo.homework.rest;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.demo.homework.dto.Product;
import ru.demo.homework.dto.Products;
import ru.demo.homework.service.ProductService;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping(value = "/{productId}")
    public Product getProduct(@PathVariable Long productId) {
        log.info("Принят запрос на получение продукта с идентификатором: {}", productId);
        return productService.getById(productId);
    }

    @GetMapping
    public Products getProducts(@RequestParam Long userId) {
        log.info("Принят запрос на получение продуктов с идентификатором пользователя: {}", userId);
        return productService.getByUserId(userId);
    }
}
