package tecazuay.edu.ec.auth_service.resources.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record AuthenticationRequest(
        String username,
        String password
) {
}
