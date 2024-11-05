package tecazuay.edu.ec.auth_service.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tecazuay.edu.ec.auth_service.exception.InvalidPasswordException;
import tecazuay.edu.ec.auth_service.repository.UserRepository;
import tecazuay.edu.ec.auth_service.resources.entity.User;
import tecazuay.edu.ec.auth_service.resources.model.UserRequest;
import tecazuay.edu.ec.auth_service.service.UserService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;


    @Override
    public User registerUser(UserRequest userRequest) {
        validatePassword(userRequest);
        User user = new User();
        user.setUsername(userRequest.username());
        user.setPassword(passwordEncoder.encode(userRequest.password()));
        user.setName(userRequest.name());
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findOneByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    private void validatePassword(UserRequest dto) {

        if (!StringUtils.hasText(dto.password()) || !StringUtils.hasText(dto.repeatPassword())) {
            throw new InvalidPasswordException("Passwords don't match");
        }

        if (!dto.password().equals(dto.repeatPassword())) {
            throw new InvalidPasswordException("Passwords don't match");
        }

    }
}
