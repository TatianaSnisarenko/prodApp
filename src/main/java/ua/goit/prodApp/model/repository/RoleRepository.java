package ua.goit.prodApp.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.goit.prodApp.model.entity.Role;
import ua.goit.prodApp.model.entity.enums.UserRole;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    Role getByUserRole(UserRole userRole);
}
