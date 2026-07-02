package schneider.davi.gerenciamento_de_apiario.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import schneider.davi.gerenciamento_de_apiario.domain.User;
import schneider.davi.gerenciamento_de_apiario.exception.UserAlreadyExistsException;
import schneider.davi.gerenciamento_de_apiario.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;


    public User save(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent())
            throw new UserAlreadyExistsException("User with name '" + user.getUsername() + "' already exists.");

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    public String login(UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) {
        var authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        var user = (User) authentication.getPrincipal();

        return tokenService.generationToken(user);
    }
}
