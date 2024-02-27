package be.epicode.buildWeek5.payloads.invoices;

import be.epicode.buildWeek5.entities.State;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.UUID;

public record InvoiceDTO(
@NotNull(message = "Date can't be null and must be structured like this (yyyy-mm-dd)!")
@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$")
LocalDate date,
@NotNull(message = "Amount is a mandatory field!")
double amount,
@NotNull(message = "Invoice Number is a mandatory field!")
int invoiceNumber,
@NotEmpty(message = "Invoice State is a mandatory field!")
@Size(min = 3, max = 20, message = "State must contain between 3 and 20 chars!")
State invoiceState,
@NotNull(message = "Client ID mustn't be null!")
UUID clientId
){
}
