package tecazuay.edu.ec.auth_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tecazuay.edu.ec.auth_service.resources.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
