package tecazuay.edu.ec.auth_service.service.auth;


import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tecazuay.edu.ec.auth_service.resources.model.AuthenticationResponse;
import tecazuay.edu.ec.auth_service.resources.entity.User;
import tecazuay.edu.ec.auth_service.resources.model.AuthenticationRequest;
import tecazuay.edu.ec.auth_service.resources.model.UserRequest;
import tecazuay.edu.ec.auth_service.resources.model.dto.RegisteredUser;
import tecazuay.edu.ec.auth_service.service.UserService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {


    private final UserService userService;


    private final JwtService jwtService;


    private final AuthenticationManager authenticationManager;

    public RegisteredUser registerOneCustomer(UserRequest newUser) {
        User user = userService.registerUser(newUser);

        RegisteredUser userDto = new RegisteredUser();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setUsername(user.getUsername());

        String jwt = jwtService.generateToken(user, generateExtraClaims(user));
        userDto.setJwt(jwt);

        return userDto;
    }

    private Map<String, Object> generateExtraClaims(User user) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("name", user.getName());
        extraClaims.put("authorities", user.getAuthorities());

        return extraClaims;
    }

    public AuthenticationResponse login(AuthenticationRequest autRequest) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                autRequest.username(), autRequest.password()
        );

        authenticationManager.authenticate(authentication);

        Optional<User> optionalUser = userService.findOneByUsername(autRequest.username());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            String jwt = jwtService.generateToken(user, generateExtraClaims(user));
            return new AuthenticationResponse(jwt, user.getUsername(), "", "");
        } else {
            throw new UsernameNotFoundException("User not found with username: " + autRequest.username());
        }
    }

    public boolean validateToken(String jwt) {

        try {
            jwtService.extractUsername(jwt);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }
}
