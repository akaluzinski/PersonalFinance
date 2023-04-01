package eu.kaluzinski.personalfinanceservice.repositories;

import eu.kaluzinski.personalfinanceservice.model.Role;
import eu.kaluzinski.personalfinanceservice.model.RoleName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ComponentScan(basePackages = { "eu.kaluzinski.personalfinanceservice" })
public class RolesRepositoryTest {

    @Autowired
    private RolesRepository rolesRepository;

    @Test
    void shouldRunBootstrap() {
        assertThat(rolesRepository.count()).isEqualTo(0L);
    }

    @Test
    void shouldAddRolesToRepository() {
        final List<Role> roles = Arrays.asList(
                new Role(RoleName.ROLE_ADMIN),
                new Role(RoleName.ROLE_USER)
        );
        rolesRepository.saveAll(roles);
        assertThat(rolesRepository.count()).isEqualTo(2L);
    }
}