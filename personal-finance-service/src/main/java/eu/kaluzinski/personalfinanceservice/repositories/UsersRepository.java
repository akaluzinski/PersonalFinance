package eu.kaluzinski.personalfinanceservice.repositories;

import eu.kaluzinski.personalfinanceservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {
}
