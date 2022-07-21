package hu.progmatic.springpractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

// Megfelelő annotáció (általában @Component,
// de pl. @SpringBootApplication, @Service, @Respository, @Controller...)
// Alapértelmezetten singletpn (csak 1 példány).
// Példány neve: Alapértelmezetten az osztály neve kisbetűvel.
// (springPracticeApplication)
@SpringBootApplication
public class SpringPracticeApplication {
    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(SpringPracticeApplication.class, args);
    }

    // Factory metódus (@Bean annotáció)
    // Alapértelmezetten singleton (egyetlen példány).
    // Csak egyszer kerül a factory metódus meghívásra.
    // Alapértelmezett név a metódus neve lesz (run).
    @Bean
    public CommandLineRunner run() {
        return (args) -> {
            System.out.println("Beans in ApplicationContext:");

            for (String name : context.getBeanDefinitionNames()) {
                System.out.println(name);
            }
        };
    }

}
