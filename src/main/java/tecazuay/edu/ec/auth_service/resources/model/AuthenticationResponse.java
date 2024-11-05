package tecazuay.edu.ec.auth_service.resources.model;

public record AuthenticationResponse(
        String token,
        String username,
        String email,
        String role
) {
}
