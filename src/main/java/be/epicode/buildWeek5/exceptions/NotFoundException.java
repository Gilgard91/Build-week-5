package be.epicode.buildWeek5.exceptions;


import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(UUID id) {
        super("Customer with id " + id + " not Found");
    }

    public NotFoundException(String message) {
        super(message);
    }
}