package be.epicode.buildWeek5.payloads;

public record CustomerRegisterDTO(String name,
                                  String surname,
                                  String email,
                                  String password) {
}
