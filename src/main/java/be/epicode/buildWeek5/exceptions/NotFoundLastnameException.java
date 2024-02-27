package be.epicode.buildWeek5.exceptions;


public class NotFoundLastnameException extends RuntimeException {
    public NotFoundLastnameException(String lastname) {
        super("Customers starting with lastname " + lastname + " not found");
    }

}