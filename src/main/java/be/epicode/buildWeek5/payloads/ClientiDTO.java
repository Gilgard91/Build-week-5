package be.epicode.buildWeek5.payloads;

import be.epicode.buildWeek5.entities.Indirizzo;
import be.epicode.buildWeek5.enums.TipoCliente;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record ClientiDTO(
        @NotEmpty(message = "BusinessName REQUIRED")
        @Size(min = 3, max = 30, message = "The lenght of your BusinessName is not long Enough")
        String ragioneSociale,
        @NotEmpty(message = "VatNumber REQUIRED")
        @Size(min = 3, max = 30, message = "The lenght of your VatNumber is not long Enough")
        String partitaIva,
        @NotEmpty(message = "Email REQUIRED")
        @Size(min = 3, max = 30, message = "The lenght of your Email is not long Enough")
        String email,
        @NotEmpty(message = "SertionDate REQUIRED")
        @Size(min = 3, max = 30, message = "The lenght of your SertionDate is not long Enough")
        LocalDate dataInserimento,
        @NotEmpty(message = "DateLastContact REQUIRED")
        @Size(min = 3, max = 30, message = "The lenght of your DateLastContact is not long Enough")
        LocalDate dataUltimoContatto,
        @NotEmpty(message = "AnnualTurnover REQUIRED")
        @Size(min = 3, max = 30, message = "The lenght of your AnnualTurnover is not long Enough")
        int fatturatoAnnuale,
        @NotEmpty(message = "Pec REQUIRED")
        @Size(min = 3, max = 30, message = "The lenght of your Pec is not long Enough")
        String pec,
        @NotEmpty(message = "Phone number REQUIRED")
        @Size(min = 3, max = 30, message = "The lenght of your Phone number is not long Enough")
        String telefono,

        String emailContatto,
        @NotEmpty(message = "Your Name is REQUIRED")
        @Size(min = 3, max = 30, message = "The lenght of your Name is not long Enough")
        String nomeContatto,
        String cognomeContatto,

        String telefonoContatto,
        String logoAziendale,
        @NotEmpty(message = "Your ClientType is REQUIRED")
        TipoCliente tipoCliente,

        Indirizzo indirizzoSedeOperativa,
        Indirizzo indirizzoSedeLegale
) {
}
