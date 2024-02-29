package be.epicode.buildWeek5;

import be.epicode.buildWeek5.entities.ClientType;
import be.epicode.buildWeek5.entities.Customer;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CustomerTesting {
    private static Customer customer = new Customer();

    int random1 = new Random().nextInt(ClientType.values().length);


    private static Random random;

    private static LocalDate localDate;

    @Test
    public void testEmptyNotEmpty() throws Exception {

        System.out.println("TEST IF CUSTOMER IS EMPTY OR NOT");

        String allCustomerTypeString = customer.getBusinessName() +
                customer.getVatNumber() +
                customer.getEmail() +
                customer.getPec() +
                customer.getEmailContact() +
                customer.getNameContact() +
                customer.getSurnameContact() +
                customer.getBusinessLogo() +
                customer.getClientType();

        int allCustomerTyperInt = customer.getAnnualTurnover() +
                customer.getPhone() +
                customer.getPhoneContact();

        try {
//            customer.setBusinessName("");
            customer.setVatNumber("a");
            customer.setEmail("a");
            customer.setPec("a");
            customer.setEmailContact("a");
            customer.setNameContact("a");
            customer.setSurnameContact("a");
            customer.setBusinessLogo("a");
            customer.setClientType(ClientType.values()[random1].toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (
        allCustomerTypeString != null ||
      allCustomerTyperInt != 0
        ) {
    System.out.println(customer);
    System.out.println("AT LEAST ONE STATEMENT IS TRUE, SO NOT EMPTY");

    if (
            allCustomerTypeString == null ||
                    allCustomerTyperInt == 0
    ) {
        System.out.println("AT LEAST ONE STATEMENT IS FALSE, SO EMPTY");
    }

}
        assertNotNull(customer.getBusinessName());
        assertNotNull(customer.getVatNumber());
        assertNotNull(customer.getEmail());
        assertNotNull(customer.getPec());
        assertNotNull(customer.getEmailContact());
        assertNotNull(customer.getNameContact());
        assertNotNull(customer.getSurnameContact());
        assertNotNull(customer.getBusinessLogo());
        assertNotNull(customer.getClientType());
    }
}
