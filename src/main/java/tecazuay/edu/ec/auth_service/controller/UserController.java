package tecazuay.edu.ec.auth_service.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tecazuay.edu.ec.auth_service.resources.model.UserRequest;
import tecazuay.edu.ec.auth_service.resources.model.dto.RegisteredUser;
import tecazuay.edu.ec.auth_service.service.auth.AuthenticationService;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<RegisteredUser> registerUser(@RequestBody @Valid UserRequest userRequest) {
        return ResponseEntity.ok(authenticationService.registerOneCustomer(userRequest));
    }
}
