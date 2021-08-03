package ua.goit.prodApp.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.goit.prodApp.model.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String username);
}
