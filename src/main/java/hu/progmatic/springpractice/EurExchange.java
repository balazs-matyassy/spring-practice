package hu.progmatic.springpractice;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
// @Primary
public class EurExchange implements Exchange {
    public EurExchange() {
        System.out.println("Instantiating EurExchange...");
    }

    @Override
    public double fromHUF(int huf) {
        return huf / 400.0;
    }
}
