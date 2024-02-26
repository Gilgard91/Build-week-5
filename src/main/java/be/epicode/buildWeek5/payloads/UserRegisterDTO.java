package be.epicode.buildWeek5.payloads;

public record UserRegisterDTO (
        String name,
        String surname,
        String email,
        String password) {
}
