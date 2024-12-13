package com.example.homes.exception;

public class BookingNotFoundException extends RuntimeException {
    public BookingNotFoundException(String message) {
        super(message);
    }
}
// Compare this snippet from src/main/java/com/example/homes/exception/BookingNotFoundException.java: