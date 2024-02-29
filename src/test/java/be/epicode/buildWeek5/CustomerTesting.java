package be.epicode.buildWeek5;

import be.epicode.buildWeek5.entities.Customer;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CustomerTesting {
    private static Customer customer = new Customer();

    private static Random random;

    private static LocalDate localDate;

    @Test
    public void testEmptyNotEmpty() {
        System.out.println("TEST IF CUSTOMER IS EMPTY OR NOT");
//       customer.setBusinessName("a");
if (customer.getBusinessName() != null ||
        customer.getVatNumber() != null ||
        customer.getPec() != null ||
        customer.getEmail() != null ||
        customer.getEmailContact() != null
        ) {

}
        System.out.println(customer);
        assertNotNull(customer.getBusinessName());
        System.out.println("customer1 is Not Null");

    }
}
