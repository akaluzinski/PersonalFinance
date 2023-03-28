package eu.kaluzinski.personalfinanceservice.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class HealthCheckControllerTest {

    @Autowired
    private HealthCheckController healthCheckController;

    @Test
    void shouldReturnOKWhenHealthCheckCalled() {
        assertEquals("OK", healthCheckController.healthCheck());
    }

}
