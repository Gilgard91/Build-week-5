package be.epicode.buildWeek5.payloads;

import be.epicode.buildWeek5.entities.UserRole;

public record UserDTO(String username, String email, String password, String name, String surname, String avatar, UserRole role) {
}
