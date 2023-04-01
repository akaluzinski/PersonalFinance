package eu.kaluzinski.personalfinanceservice.bootstrap;

import eu.kaluzinski.personalfinanceservice.model.User;
import eu.kaluzinski.personalfinanceservice.repositories.RolesRepository;
import eu.kaluzinski.personalfinanceservice.repositories.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RolesRepository rolesRepository;
    private final UsersRepository usersRepository;

    public DataInitializer(RolesRepository rolesRepository, UsersRepository usersRepository) {
        this.rolesRepository = rolesRepository;
        this.usersRepository = usersRepository;
    }

    @Override
    public void run(String... args) {
        if (usersRepository.count() == 0) {
            final User user = new User("Pawel", "pavo", "pavopavo_example@protonmail.com", "pswd");
            usersRepository.save(user);
        }
    }
}
