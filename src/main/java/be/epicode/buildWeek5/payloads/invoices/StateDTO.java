package be.epicode.buildWeek5.payloads.invoices;

import be.epicode.buildWeek5.entities.Invoice;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

public record StateDTO(
        @NotEmpty(message = "State name is a mandatory field!")
        @Size(min = 3, max = 20, message = "State name must contain between 3 and 20 chars!")
        String stateName,

        @NotEmpty(message = "Invoice List is Required!")
        List<Invoice> invoices
) {
}
