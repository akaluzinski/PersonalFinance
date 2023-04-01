package eu.kaluzinski.personalfinanceservice.repositories;

import eu.kaluzinski.personalfinanceservice.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ComponentScan(basePackages = { "eu.kaluzinski.personalfinanceservice" })
public class UsersRepositoryTest {

    @Autowired
    private UsersRepository usersRepository;

    @Test
    void shouldNotAddUserToRepository() {
        final User user = new User();
        usersRepository.save(user);
        assertThat(usersRepository.count()).isEqualTo(2L);
    }

    @Test
    void shouldAddUserToRepository() {
        final User user = new User("TestyPawel", "testypavo", "testypavopavo_example@protonmail.com", "pswd");
        usersRepository.save(user);
        assertThat(usersRepository.count()).isEqualTo(2L);
    }
}