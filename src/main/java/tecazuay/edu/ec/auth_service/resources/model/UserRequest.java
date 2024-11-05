package tecazuay.edu.ec.auth_service.resources.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserRequest(
        @Size(min = 4, max = 20)
        String name,
        String username,
        @Size(min = 8)
        String password,
        @Size(min = 8)
        String repeatPassword
) {
}
