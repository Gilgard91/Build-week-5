package be.epicode.buildWeek5.payloads;

import be.epicode.buildWeek5.entities.Cliente;
import be.epicode.buildWeek5.entities.StatoFattura;

import java.time.LocalDate;

public record FattureDTO(
//@NotNull(message = "Date can't be null and must be structured like this (yyyy-mm-dd)!")
//@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$")
LocalDate data,
//@NotNull(message = "Amount is a mandatory field!")
double importo,

Cliente cliente,

StatoFattura statoFattura

){
}
