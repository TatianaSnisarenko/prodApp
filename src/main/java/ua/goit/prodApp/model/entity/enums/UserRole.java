package ua.goit.prodApp.model.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@AllArgsConstructor
@Getter
public enum UserRole {
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_USER("ROLE_USER");

    private String role;

    public static Optional<UserRole> getUserRole(String role) {
        return Arrays.stream(UserRole.values())
                .filter(value -> value.getRole().equals(role))
                .findAny();
    }

}
