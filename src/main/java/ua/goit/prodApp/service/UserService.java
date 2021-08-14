package ua.goit.prodApp.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.goit.prodApp.exceptions.UserAlreadyExistException;
import ua.goit.prodApp.model.entity.User;
import ua.goit.prodApp.model.entity.enums.UserRole;
import ua.goit.prodApp.model.repository.RoleRepository;
import ua.goit.prodApp.model.repository.UserRepository;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    private final RoleRepository roleRepository;

    public void register(User user) {
        log.info("register .");
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            log.error(String.format("register . User with specified email already exists %s", user.getEmail()));
            throw new UserAlreadyExistException(String.format("User with specified email already exists %s", user.getEmail()));
        }
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRoles(List.of(roleRepository.getByUserRole(UserRole.ROLE_USER)));
        userRepository.save(user);
    }

    public void create(User user) {
        log.info("create .");
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            log.error(String.format("create . User with specified email already exists %s", user.getEmail()));
            throw new UserAlreadyExistException(String.format("User with specified email already exist %s", user.getEmail()));
        }
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }


    public User update(User user) {
        log.info("update .");
        return userRepository.save(user);
    }

    public List<User> findAll() {
        log.info("findAll .");
        return userRepository.findAll();
    }

    public Optional<User> findById(UUID id) {
        log.info("findById .");
        return userRepository.findById(id);
    }

    public void deleteById(UUID id) {
        log.info("deleteById .");
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            log.error("deleteById . No such index in database");
            throw new NoSuchElementException("No such index in database");
        }
    }

    public boolean isLastAdmin(User user) {
        if (!hasAdminRole(user)) {
            return false;
        } else {
            return userRepository.findAll().stream().map(User::getRoles)
                    .flatMap(Collection::stream)
                    .filter(role -> role.getUserRole() == UserRole.ROLE_ADMIN)
                    .count() == 1L;
        }
    }

    private boolean hasAdminRole(User user) {
        return user.getRoles().stream().anyMatch(role -> role.getUserRole() == UserRole.ROLE_ADMIN);
    }
}
