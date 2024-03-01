package be.epicode.buildWeek5.payloads;

import be.epicode.buildWeek5.enums.RuoloUtente;

public record UtentiDTO(String username, String email, String password,
                        String nome, String cognome, String avatar, RuoloUtente ruolo) {
}
