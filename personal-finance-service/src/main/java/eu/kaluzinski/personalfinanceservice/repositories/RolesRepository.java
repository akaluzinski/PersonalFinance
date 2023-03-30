package eu.kaluzinski.personalfinanceservice.repositories;

import eu.kaluzinski.personalfinanceservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Role, Long> {
}