package be.epicode.buildWeek5.payloads.invoices;

import be.epicode.buildWeek5.entities.Customer;
import be.epicode.buildWeek5.entities.State;

import java.time.LocalDate;

public record InvoiceDTO(
//@NotNull(message = "Date can't be null and must be structured like this (yyyy-mm-dd)!")
//@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$")
LocalDate date,
//@NotNull(message = "Amount is a mandatory field!")
double amount,

Customer customer,

State invoiceState

){
}
