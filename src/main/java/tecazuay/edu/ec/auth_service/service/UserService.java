package tecazuay.edu.ec.auth_service.service;



import tecazuay.edu.ec.auth_service.resources.entity.User;
import tecazuay.edu.ec.auth_service.resources.model.UserRequest;

import java.util.Optional;

public interface UserService {
    User registerUser(UserRequest userRequest);

    Optional<User> findOneByUsername(String username);
}
