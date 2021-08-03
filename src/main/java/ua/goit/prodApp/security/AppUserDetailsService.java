package ua.goit.prodApp.security;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.prodApp.model.entity.User;
import ua.goit.prodApp.model.repository.UserRepository;

@Slf4j
@Service(value = "userServiceDetails")
@AllArgsConstructor
public class AppUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername .");
        final User user = userRepository.findByEmail(username).orElseThrow(() ->
                new UsernameNotFoundException(String.format("user with username %s not exists", username)));
        return new UserPrincipal(user);
    }
}
