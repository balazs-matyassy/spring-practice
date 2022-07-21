package hu.progmatic.springpractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MainRunner implements CommandLineRunner {
    @Autowired
    private ApplicationContext context;

    // Itt már be van állítva az ApplicationContext ("doboz").
    // Belépési pont ("pót main metódus")
    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hány forintod van?");
        int huf = scanner.nextInt();

        Exchange exchange = (Exchange) context.getBean("eurExchange");
        double currency = exchange.fromHUF(huf);

        System.out.println("Ennyi külföldi pénzed van: " + currency);
    }
}
