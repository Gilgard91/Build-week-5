package be.epicode.buildWeek5.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CustomerRegisterDTO(
        @NotEmpty(message = "BusinessName REQUIRED")
                @Size(min = 3,max = 30, message = "The lenght of your BusinessName is not long Enough")
        String businessName,
        @NotEmpty(message = "VatNumber REQUIRED")
        @Size(min = 3,max = 30, message = "The lenght of your VatNumber is not long Enough")
String vatNumber,
        @NotEmpty(message = "Email REQUIRED")
        @Size(min = 3,max = 30, message = "The lenght of your Email is not long Enough")
        String email,
        @NotEmpty(message = "SertionDate REQUIRED")
        @Size(min = 3,max = 30, message = "The lenght of your SertionDate is not long Enough")
        LocalDate sertionDate,
        @NotEmpty(message = "DateLastContact REQUIRED")
                 @Size(min = 3,max = 30, message = "The lenght of your DateLastContact is not long Enough")
        LocalDate dateLastContact,
        @NotEmpty(message = "AnnualTurnover REQUIRED")
                 @Size(min = 3,max = 30, message = "The lenght of your AnnualTurnover is not long Enough")
        int annualTurnover,
        @NotEmpty(message = "Pec REQUIRED")
                 @Size(min = 3,max = 30, message = "The lenght of your Pec is not long Enough")
        String pec,
        @NotEmpty(message = "Phone number REQUIRED")
                 @Size(min = 3,max = 30, message = "The lenght of your Phone number is not long Enough")
        int phone) {
}
