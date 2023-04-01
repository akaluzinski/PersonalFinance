package eu.kaluzinski.personalfinanceservice.repositories;

import eu.kaluzinski.personalfinanceservice.model.User;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ComponentScan(basePackages = {"eu.kaluzinski.personalfinanceservice"})
public class UsersRepositoryTest {

    @Autowired
    private UsersRepository usersRepository;

    @Test
    void shouldNotAddUserWithoutNameToRepository() {
        final User user = new User("", "testypavo", "testypavopavo_example@protonmail.com", "pswd");
        assertConstraintExceptionThrownOnSave(user, "must not be blank", "name");
    }

    @Test
    void shouldNotAddUserWithBlankUsernameToRepository() {
        final User user = new User("Na", "    ", "testypavopavo_example@protonmail.com", "pswd");
        assertConstraintExceptionThrownOnSave(user, "must not be blank", "username");
    }

    @Test
    void shouldNotAddUserWithBlankEmailToRepository() {
        final User user = new User("Na", "usernam", "", "pswd");
        assertConstraintExceptionThrownOnSave(user, "must not be blank", "email");
    }


    @Test
    void shouldNotAddUserWithInvalidEmailToRepository() {
        final User user = new User("Na", "usernam", "@", "pswd");
        assertConstraintExceptionThrownOnSave(user, "must be a well-formed email address", "email");
    }

    @Test
    void shouldNotAddUserWithShortPasswordToRepository() {
        final User user = new User("Na", "usernam", "correct@example.mail", "ops");
        assertConstraintExceptionThrownOnSave(user, "size must be between 4 and 100", "password");
    }

    @Test
    void shouldAddUserToRepository() {
        final User user = new User("TestyPawel", "testypavo", "testypavopavo_example@protonmail.com", "pswd1");
        usersRepository.save(user);
        assertThat(usersRepository.count()).isEqualTo(2L);
    }

    private void assertConstraintExceptionThrownOnSave(User user, String message, String propertyPath) {
        ConstraintViolationException thrown = assertThrows(ConstraintViolationException.class,
                () -> usersRepository.save(user));

        assertEquals(1, thrown.getConstraintViolations().size());

        ConstraintViolation violation = thrown.getConstraintViolations().stream().findFirst().orElseThrow();
        assertEquals(message, violation.getMessage());
        assertEquals(propertyPath, violation.getPropertyPath().toString());
    }

}