package hu.progmatic.springpractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MainRunner implements CommandLineRunner {
    private final ApplicationContext context;

    // field-injection
    // @Autowired
    // private Exchange exchange;

    private final Exchange exchange;

    // constructor-injection
    // Több Exchange típussal kompatibilis bean esetében a @Primary annotáció dönt.
    // Ha a típust átírom EurExchange-re, akkor már csak kompatibilis bean van.
    // @Qualifier (felülírja a @Primary-t)
    // public MainRunner(ApplicationContext context, @Qualifier("eurExchange") Exchange exchange) { ...
    public MainRunner(ApplicationContext context, Exchange exchange) {
        this.context = context;
        this.exchange = exchange;
    }

    // Itt már be van állítva az ApplicationContext ("doboz").
    // Belépési pont ("pót main metódus")
    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hány forintod van?");
        int huf = scanner.nextInt();

        // Név alapján kivesszük a kontextusból a beant.
        // Exchange exchange = (Exchange) context.getBean("eurExchange");
        double currency = exchange.fromHUF(huf);

        System.out.println("Ennyi külföldi pénzed van: " + currency);
    }
}
