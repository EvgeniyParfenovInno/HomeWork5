package ru.demo.homework.exception;

public class ItemNotExistsException extends RuntimeException {
    public ItemNotExistsException(String message) {
        super(message);
    }
}
