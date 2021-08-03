package ua.goit.prodApp.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import ua.goit.prodApp.exceptions.UserAlreadyExistException;
import ua.goit.prodApp.model.entity.Role;
import ua.goit.prodApp.model.entity.User;
import ua.goit.prodApp.model.entity.enums.UserRole;
import ua.goit.prodApp.service.RoleService;
import ua.goit.prodApp.service.UserService;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/users")
@AllArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;
    private final RoleService roleService;

    @GetMapping("/registration")
    public String showRegistrationPage() {
        log.info("showRegistrationPage .");
        return "registration";
    }

    @PostMapping("/registration")
    public String register(@ModelAttribute("userForm") @Valid User user, BindingResult result, Model model) {
        log.info("register .");
        if (result.hasErrors()) {
            log.error("register . has errors");
            return "registration";
        }
        try {
            userService.register(user);
        } catch (UserAlreadyExistException ex) {
            log.error("register . Account with provided email already exists");
            model.addAttribute("message", "Account with provided email already exists");
            return "registration";
        }
        return "redirect:/login";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping()
    public String viewListOfUsers(Model model) {
        log.info("viewListOfUsers .");
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/form/add")
    public String addNewUser(@ModelAttribute("userForm") @Valid User user,
                             BindingResult result, Model model,
                             @RequestParam(name = "rolesIds", required = false) String[] rolesIds) {
        log.info("addNewUser .");
        if (result.hasErrors()) {
            log.error("addNewUser . has errors");
            model.addAttribute("allRoles", roleService.findAll());
            return "addFormUser";
        }
        List<Role> roles = List.of(roleService.getByUserRole(UserRole.ROLE_USER));
        if (rolesIds != null && rolesIds.length > 0) {
            roles = Arrays.stream(rolesIds).map(UUID::fromString).map(uuid -> roleService.findById(uuid).get())
                    .collect(Collectors.toList());
        }
        user.setRoles(roles);
        try{
        userService.create(user);
        } catch (UserAlreadyExistException ex) {
            log.error("addNewUser . Account with provided email already exists");
            model.addAttribute("message", "Account with provided email already exists");
            model.addAttribute("allRoles", roleService.findAll());
            return "addFormUser";
        }
        return "redirect:/users";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(path = "/update")
    public RedirectView updateUser(@ModelAttribute("userForm") @Valid User user) {
        log.info("updateUser .");
        userService.update(user);
        return new RedirectView("/users");
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(path = "/form/add")
    public String showUserAddForm(Model model) {
        log.info("showUserAddForm .");
        model.addAttribute("allRoles", roleService.findAll());
        return "addFormUser";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(path = "/delete")
    public RedirectView deleteUser(@RequestParam(name = "id") UUID id) {
        log.info("deleteUser .");
        userService.deleteById(id);
        return new RedirectView(("/users"));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(path = "/form/update")
    public String showUserUpdateForm(@RequestParam(name = "id") UUID id, Model model) {
        log.info("showUserUpdateForm .");
        try {
            model.addAttribute("user", userService.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("No such index in database")));
            model.addAttribute("allRoles", roleService.findAll());
        } catch (Throwable throwable) {
            log.error("showUserUpdateForm .", throwable.getMessage());
        }
        return "updateFormUser";
    }

    @ModelAttribute("userForm")
    public User defaultUser() {
        return new User();
    }
}
