package eu.kaluzinski.personalfinanceservice.bootstrap;

import eu.kaluzinski.personalfinanceservice.repositories.RolesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RolesRepository rolesRepository;

    public DataInitializer(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    @Override
    public void run(String... args) {


    }
}
