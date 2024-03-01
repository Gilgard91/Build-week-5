package be.epicode.buildWeek5.payloads;

import be.epicode.buildWeek5.entities.Comune;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record IndirizziDTO(
        @NotEmpty(message = "Street is mandatory")
        @Size(min = 3, max = 20, message = "This street must have at least 3 to maximum 20 characters")
        String via,
        @NotEmpty(message = "Number is mandatory")
        @NotBlank
        Integer civico,
        @NotEmpty(message = "Postal Code is mandatory")
        Integer cap,
        @NotEmpty(message = "Municipality is mandatory")
        @Size(min = 3, max = 30, message = "Municipality must have at least 3 characters and max 30")
        Comune comune

) {
}
