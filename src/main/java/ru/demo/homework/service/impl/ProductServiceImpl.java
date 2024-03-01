package ru.demo.homework.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.demo.homework.dto.Product;
import ru.demo.homework.dto.Products;
import ru.demo.homework.entity.ProductEntity;
import ru.demo.homework.exception.DatabaseCommonException;
import ru.demo.homework.exception.ItemNotExistsException;
import ru.demo.homework.repository.ProductDao;
import ru.demo.homework.service.ProductService;

import java.sql.SQLException;

@Slf4j
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    @Override
    public Product getById(Long id) {
        if (id == null || id < 0)
            throw new IllegalArgumentException("Получен некорректный идентификатор продукта: " + id);

        try {
            return productDao.getById(id)
                    .map(this::mapToProduct)
                    .orElseThrow(() -> new ItemNotExistsException("Не найден продукт с идентификатором " + id));
        } catch (SQLException e) {
            log.error("При выполнении запроса обнаружена ошибка: {}", e.getMessage());
            throw new DatabaseCommonException("Получение продукта с идентификатором " + id + " завершилось ошибкой");
        }
    }

    @Override
    public Products getByUserId(Long userId) {
        try {
            return new Products().setItems(
                    productDao.getByUserId(userId).stream()
                            .map(this::mapToProduct)
                            .toList());
        } catch (SQLException e) {
            log.error("При выполнении запроса обнаружена ошибка: {}", e.getMessage());
            throw new DatabaseCommonException("Получение продуктов по идентификатору пользователя завершилось ошибкой");
        }
    }

    private Product mapToProduct(ProductEntity entity) {
        return new Product()
                .setAccount(entity.getAccount())
                .setId(entity.getId())
                .setType(entity.getType())
                .setBalance(entity.getBalance());
    }
}
