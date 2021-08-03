package ua.goit.prodApp.security;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import ua.goit.prodApp.model.entity.User;

import java.util.Collection;
import java.util.stream.Collectors;

@Slf4j
@Component
@AllArgsConstructor
public class UserPrincipal implements UserDetails {
    private final User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        log.info("getAuthorities .");
        return user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getUserRole().getRole()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        log.info("getPassword .");
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        log.info("getUsername");
        return this.user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        log.info("isAccountNonExpired .");
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        log.info("isAccountNonLocked .");
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        log.info("isCredentialsNonExpired .");
        return true;
    }

    @Override
    public boolean isEnabled() {
        log.info("isEnabled .");
        return true;
    }
}
