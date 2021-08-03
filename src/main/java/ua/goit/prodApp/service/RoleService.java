package ua.goit.prodApp.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ua.goit.prodApp.exceptions.DataBaseException;
import ua.goit.prodApp.model.entity.Role;
import ua.goit.prodApp.model.entity.enums.UserRole;
import ua.goit.prodApp.model.repository.RoleRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role createOrUpdate(Role role) {
        log.info("createOrUpdate .");
        try {
            return roleRepository.save(role);
        } catch (Exception e) {
            log.error(String.format("createOrUpdate . exception saving role with name=%s", role.getUserRole()), e);
            throw new DataBaseException(
                    String.format("Role with name=%s wasn't saved into database", role.getUserRole()));
        }
    }

    public List<Role> findAll() {
        log.info("findAll .");
        return roleRepository.findAll();
    }

    public Optional<Role> findById(UUID id) {
        log.info("findById .");
        return roleRepository.findById(id);
    }

    public void deleteById(UUID id) {
        log.info("deleteById .");
        try {
            roleRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            log.error("deleteById . No such index in database");
            throw new NoSuchElementException("No such index in database");
        }
    }

    public Role getByUserRole(UserRole roleUser) {
        log.info("getByUserRole .");
        return roleRepository.getByUserRole(roleUser);
    }
}
